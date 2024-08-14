<script setup lang="ts">
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";
import myAXios from "../plugins/myAXios.ts";
import {Toast} from "vant";
import {getCurrentUser} from "../states/user.ts";

const router = useRouter();

const route = useRoute();
const editUser = ref({
  editKey: route.query.editKey,
  currentValue: route.query.currentValue,
  editName: route.query.editName,
})

const onSubmit = async () => {
  //获取当前用户信息
  const currentUser = await getCurrentUser();
  if (!currentUser) {
    Toast.fail('用户未登录，请重新登录');
    router.push('/user/login');
  }

  // 把editKey.currentVale提交给后台
  const result = await myAXios.post('/user/update', {
    'id': currentUser.id,
    [editUser.value.editKey]: editUser.value.currentValue
  })
  if (result.code === 200) {
    Toast.success('修改成功')
  } else {
    Toast.fail('修改失败，请联系管理员')
  }
  //延迟两秒刷新回主页面
  setTimeout(()=>{
    router.push('/user')
  },2000)

}
</script>

<template>
  <van-form @submit="onSubmit">
    <van-cell-group inset>
      <van-field
          v-model="editUser.currentValue"
          :name="editUser.editKey"
          :label="editUser.editName"
          :placeholder="`请输入手机号${editUser.editName}`"
      />
    </van-cell-group>
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>
</template>

<style scoped>

</style>