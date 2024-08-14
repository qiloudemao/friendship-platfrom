<script setup lang="ts">
import {useRouter} from "vue-router";
import {onMounted, ref} from "vue";
import myAXios from "../plugins/myAXios.ts";
import {Toast} from "vant";

// const user = {
//   id: 1,
//   username: 'wt',
//   userAccount: 'qiloudemoa',
//   avatarUrl: 'https://cn.bing.com/images/search?q=%E7%9A%AE%E5%8D%A1%E4%B8%98%E5%9B%BE%E7%89%87&FORM=IQFRBA&id=FD770467996AA18BC90913125BB5C671BE093854',
//   gender: '男',
//   phone: '213213123123',
//   email: '231231@qq.com',
//   planetCode: '12234',
//   createTime: new Date(),
// }

const user =ref();
const router = useRouter();


onMounted(async () =>{
  console.log("执行了")
  const res = await myAXios.get('/user/current');
  if (res.code === 200){
    user.value = res.data;
    // Toast.success('获取用户信息成功');
  } else {
    Toast.fail('获取用户信息失败，请重新登录');
    // router.push('/user/login');
  }
})


const toEdit = (editKey: string, editName: string, currentValue: string) => {
  router.push({
    path: '/user/edit',
    query: {
      editKey,
      editName,
      currentValue,
    }
  })
}

// const fileList = ref([
//   { url: 'https://fastly.jsdelivr.net/npm/@vant/assets/leaf.jpeg' },
//   // Uploader 根据文件后缀来判断是否为图片文件
//   // 如果图片 URL 中不包含类型信息，可以添加 isImage 标记来声明
//   { url: 'https://cloud-image', isImage: true },
// ]);
</script>

<template>
  <template v-if="user">
    <van-cell-group inset>
      <van-cell title="昵称" is-link to="/user/edit" :value="user.username"
                @click="toEdit('username','昵称',user.username)"/>
      <van-cell title="账户" :value="user.userAccount"/>
      <van-cell title="头像" >
        <img style="height: 48px" :src="user.avatarUrl">
<!--        <van-uploader v-model="user.avatarUrl" multiple />-->
      </van-cell>
<!--      <van-uploader v-model="user.avatarUrl" multiple />-->
      <van-cell title="性别"  :value="user.gender===0?'男':'女'"/>
      <van-cell title="电话" is-link to="/user/edit" :value="user.phone" @click="toEdit('phone','电话',user.phone)"/>
      <van-cell title="邮箱" is-link to="/user/edit" :value="user.email" @click="toEdit('email','邮箱',user.email)"/>
      <van-cell title="星球编号" :value="user.planetCode"/>
    </van-cell-group>

    <van-cell title="修改信息" is-link to="/user/update"/>
    <van-cell title="我创建的队伍" is-link to="/team/create"/>
    <van-cell title="我加入的队伍" is-link to="/team/join"/>
<!--          <van-uploader v-model="user.avatarUrl" multiple />-->


  </template>
</template>

<style scoped>

</style>

