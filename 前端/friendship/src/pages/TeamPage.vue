<script setup lang="ts">

import {useRouter} from "vue-router";
import {onMounted, ref} from "vue";
import myAXios from "../plugins/myAXios.ts";
import {Toast} from "vant";
import TeamCardList from "../components/TeamCardList.vue";

const router = useRouter();


const teamList=ref([]);
const searchText = ref("");

const active=ref('public');

//队伍搜索方法
const listTeam=async (val='',status=0)=>{
  const res=await myAXios.get("/team/list",{
    params:{
      searchText:val,
      pagaNum:1,
      status,
    }
  });
  if(res?.code===200){
    teamList.value=res.data;
  }
  else Toast.fail("加载队伍失败，请刷新")
}

//页面加载时触发一次，查询队伍
onMounted(async()=>{
  listTeam()
})

//搜索
const onSearch = (val) => {
  listTeam(val)
}

//跳转到加入队伍页面
const toAddTeam=()=>{
  router.push({
    path:"/team/add"
  })
}

const onTabChange = (name) => {
  //查公开
  if(name === "public"){
    listTeam(searchText.value,0)
  }
  else listTeam(searchText.value,2)
}
</script>

<template>
  <van-search v-model="searchText" shape="round" background="#4fc08d" placeholder="请输入搜索关键词" @search="onSearch"/>
  <div id="teamPage">
    <van-tabs v-model:active="active" @change="onTabChange">
      <van-tab title="公开" name="public"/>
      <van-tab title="加密" name="private"/>
    </van-tabs>
<!--<van-button type="primary" @click="doJoinTeam">添加队伍</van-button>-->
    <van-button class="add-button" type="primary" icon="plus" @click="toAddTeam"/>
    <team-card-list :teamList="teamList"/>
    <van-empty v-if="teamList.length <1" description="数据为空"/>
  </div>


</template>

<style scoped>

</style>