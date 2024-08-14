<template>
  <van-nav-bar
      :title="title"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
  >
      <template #right>
        <van-icon name="search" size="18" />
      </template>
  </van-nav-bar>

  <div id="content">
    <router-view />
  </div>

  <van-tabbar v-model="active" @change="onChange">
    <van-tabbar-item to="/" icon="home-o" name="index">主页</van-tabbar-item>
    <van-tabbar-item to="/team" icon="search" name="team">队伍</van-tabbar-item>
    <van-tabbar-item to="/user" icon="friends-o" name="user">个人</van-tabbar-item>
  </van-tabbar>

</template>

<script setup>
import { ref } from 'vue';
import { Toast } from 'vant';
import { useRouter } from "vue-router";
import routes from "../config/router.ts";


const router =useRouter()
const onClickLeft = () => {
  router.back()
};
const onClickRight = () =>{
  // alert('you')
  router.push('/search')
};

/**
 * 根据路由切换标题
 */
router.beforeEach((to,from)=>{
  const toPath = to.path;
  const route = routes.find(route=>
      toPath === route.path);
  title.value=route?.title??DEFAULT_TITLE;
})

// const active = ref("index");
// const onChange = (index) => Toast(`标签 ${index}`);

const DEFAULT_TITLE='WT伙伴匹配系统'
const title=ref(DEFAULT_TITLE);
</script>

<style scoped>
#content{
  padding-bottom: 50px;
}
</style>