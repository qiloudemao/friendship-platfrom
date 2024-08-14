<script setup lang="ts">
import {ref} from 'vue';
import {useRouter} from "vue-router";

const searchText = ref('');

//选择标签
const activeIds = ref([]);
const activeIndexs = ref(0);

const originTagList=[
  {
    text: '性别',
    children: [
      {text: '男', id: '男'},
      {text: '女', id: '女'},
      {text: '未知', id: '未知'},
    ],
  },
  {
    text: '年级',
    children: [
      {text: '大一', id: '大一'},
      {text: '大二', id: '大二'},
      {text: '大三', id: '大三'},
    ],
  },

];


//标签数组
let tagList = ref(originTagList);

//标签删除函数
const close = (tag:any) => {
  activeIds.value = activeIds.value.filter((item) => tag !== item)
}
//搜索标签函数
const onSearch = (val) => {
   tagList.value=originTagList.map( parentTag=>{
    const tempChildren=[...parentTag.children];
    const tempParentTag={...parentTag};
    tempParentTag.children=tempChildren.filter(item => item.text.includes(searchText.value))
    return tempParentTag;
  })
}
//取消函数
const onCancel = () => {
  searchText.value = '';
  tagList.value = originTagList;
}
//搜索结果函数
const router=useRouter();
const doSearchResult= ()=>{
  router.push({
    path:'/user/list',
    query:{
      tags:activeIds.value,
    }
  })
}
</script>

<template>
  <form action="/">
    <van-search
        v-model="searchText"
        show-action
        background="#4fc08d"
        placeholder="请输入搜索相关标签"
        @search="onSearch"
        @cancel="onCancel"
    />
  </form>
  <van-divider v-if="activeIds.length===0"
               :style="{ color: '#1989fa', borderColor: '#1989fa', padding: '0 16px' }"
  >
    请选择标签
  </van-divider>
  <van-divider v-else
               :style="{ color: '#1989fa', borderColor: '#1989fa', padding: '0 16px' }"
  >
    已选择标签
  </van-divider>
  <!--  <van-divider v-if="activeIds.length===0" content-position="left">请选择标签</van-divider>-->
  <!--  <div v-if="activeIds.length===0 ">请选择标签</div>-->
  <van-row gutter="16" style="padding: 0 16px">
    <van-col v-for=" tag in activeIds">
      <van-tag closeable color="#7232dd" size ="small" type="primary" @close="close(tag)">
        {{ tag }}
      </van-tag>
    </van-col>
  </van-row>

  <van-divider content-position="left">可选择标签</van-divider>

  <van-tree-select
      v-model:active-id="activeIds"
      v-model:main-active-index="activeIndexs"
      :items="tagList"
  />
  <div style="padding: 16px">
    <van-button block type="primary" @click="doSearchResult">
      搜索
    </van-button>
  </div>
</template>


<style scoped>

</style>