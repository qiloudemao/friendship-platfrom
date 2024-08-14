<script setup lang="ts">
import {ref} from "vue";
import myAXios from "../plugins/myAXios.ts";
import {Toast} from "vant";
import {useRoute, useRouter} from "vue-router";

const router = useRouter();
const route = useRoute();

const userAccount = ref('');
const userPassword = ref('');
const onSubmit = async () => {
  const res = await myAXios.post('user/login', {
    userAccount: userAccount.value,
    userPassword: userPassword.value,
  })
  console.log(res, '用户登录');
  if (res.code === 200 && res.data) {
    Toast.success('登录成功');
    //跳转到之前的页面
    const redirectUrl = route.query?.redirect as string?? '/';
    window.location.href = redirectUrl;
    // router.replace('/user');
  } else {
    Toast.fail('登录失败，请重新输入');
  }
};
</script>

<template>
  <van-form @submit="onSubmit">
  <van-cell-group inset>
    <van-field
        v-model="userAccount"
        name="userAccount"
        label="账号"
        placeholder="账号"
        :rules="[{ required: true, message: '请填写用户名' }]"
    />
    <van-field
        v-model="userPassword"
        type="password"
        name="userPassword"
        label="密码"
        placeholder="请输入密码"
        :rules="[{ required: true, message: '请填写密码' }]"
    />
  </van-cell-group>
  <div style="margin: 16px;">
    <van-button round block type="primary" native-type="submit">
      登录
    </van-button>
  </div>

  </van-form>
</template>

<style scoped>

</style>


