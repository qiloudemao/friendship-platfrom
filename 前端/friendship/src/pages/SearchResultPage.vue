<script setup lang="ts">
import {useRoute} from "vue-router";
import {onMounted, ref} from "vue";
import myAXios from "../plugins/myAXios.ts";
import {Toast} from "vant";
import qs from "qs";
import UserCardList from "../components/UserCardList.vue";

const route = useRoute();
const {tags} = route.query;
// const mockUser = ref({
//   id: 931,
//   username: '沙鱼',
//   userAccount: 'wt',
//   profile: '一条咸鱼',
//   gender: 0,
//   phone: '123456789101',
//   email: 'shayu-yusha@qq.com',
//   planetCode: '931',
//   avatarUrl: 'https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/shayu.png',
//   tags: ['java', 'emo', '打工中', 'emo', '打工中'],
//   createTime: new Date(),
// })
const userList = ref([]);

onMounted(async () => {
  const userListData = await myAXios.get('/user/search/tags', {
    // withCredentials:true,
    params: {
      tagNameList: tags
    },
    // 序列化
    paramsSerializer: {
      serialize: params => qs.stringify(params, {indices: false}),
    }
  })
      
      .then((response) => {
        console.log(response);
        Toast.success('请求成功');
        return response?.data;
      })
      .catch((error) => {
        console.log(error);
        Toast.fail('请求失败');
      })
  if (userListData) {
    userListData.forEach(user => {
      if (user.tags) {
        user.tags = JSON.parse(user.tags);
      }
    })
    userList.value = userListData;
  }

})


</script>

<template>
  <user-card-list :user-list="userList"/>
</template>

<style scoped>

</style>