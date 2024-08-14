package com.wt.friendship.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.friendship.model.domain.User;
import com.wt.friendship.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.wt.friendship.constant.UserConstant.USER_CACHE_LOCK;
import static com.wt.friendship.constant.UserConstant.USER_RECOMMEND;

@Component
@Slf4j
public class PreCacheJob {
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate redisTemplate;
    //重点用户
    @Resource
    private RedissonClient redissonClient;

    private List<Long> mainUserList = Arrays.asList(1L);

    @Scheduled(cron = "59 59 23 * * *")
    public void doCacheRecommendUser() {
        RLock lock = redissonClient.getLock(USER_CACHE_LOCK);
        log.info("doCache准备");
        try {
            if (lock.tryLock(0, -1, TimeUnit.SECONDS)) {
                for (Long userId : mainUserList) {
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                    String redisKey = String.format(USER_RECOMMEND, userId);
                    ValueOperations valueOperations = redisTemplate.opsForValue();
                    //写入缓存一天过期
                    try {
                        valueOperations.set(redisKey, userPage, 15 * 60 * 24, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }
            }
            log.info("doCache成功");
        } catch (InterruptedException e) {
            log.error("doCacheRecommendUser error");
        } finally {
            //判断是否是当前线程加锁，是则解锁。
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
