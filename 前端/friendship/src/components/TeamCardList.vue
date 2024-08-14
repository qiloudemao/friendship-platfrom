<script setup lang="ts">
import {teamType} from "../models/team.d.ts";
import {teamStatusEnum} from "../constants/team.ts";
import myAXios from "../plugins/myAXios.ts";
import {Dialog, Toast} from "vant";
import {onMounted, ref} from "vue";
import {getCurrentUser} from "../states/user.ts";
import {useRouter} from "vue-router";
import {userType} from "../models/user";

interface UserCardListProps {
  teamList: teamType[];
}

const props = withDefaults(defineProps<UserCardListProps>(), {
  //@ts-ignore
  teamList: [] as userType[]
});

const currentUser = ref();
const password = ref('');
const joinTeamId = ref(0);
const showPasswordDialog = ref(false);
const router = useRouter();

const VanDialog = Dialog.Component;

onMounted(async () => {
  currentUser.value = await getCurrentUser();
})

/**
 * 加入队伍
 */
const doJoinTeam = async () => {
  if (!joinTeamId.value) {
    return;
  }
  const res = await myAXios.post('/team/join', {
    teamId: joinTeamId.value,
    password: password.value
  });
  if (res?.code === 200) {
    Toast.success('加入成功');
    doJoinCancel();
  } else {
    Toast.fail('加入失败' + (res.description ? `，${res.description}` : ''));
  }
}

const preJoinTeam = (team: teamType) => {
  joinTeamId.value = team.id;
  if (team.status === 0) {
    doJoinTeam();
  } else {
    showPasswordDialog.value = true;
  }
}

const doJoinCancel = () => {
  joinTeamId.value = 0;
  password.value = '';
}

const doUpdateTeam = (id: number) => {
  router.push({
    path: "/team/update",
    query: {
      id,
    }
  })
}
/**
 * 退出队伍
 * @param id
 */
const doQuitTeam = async (id: number) => {
  const res = await myAXios.post("/team/quit", {
    teamId: id
  });
  if (res.code === 200) {
    Toast.success("操作成功");
  } else Toast.fail("操作失败" + (res.description ? `,${res.description}` : ''));
}
/**
 * 删除队伍
 * @param id
 */
const doDeleteTeam = async (id: number) => {
  const res = await myAXios.post("/team/delete", {
    id
  });
  if (res.code === 200) {
    Toast.success("操作成功")
  } else Toast.fail("操作失败" + (res.description ? `,${res.description}` : ''));
}

</script>

<template>
  <!--  <div id="teamCardList">-->
  <van-card
      v-for="team in props.teamList"
      :desc="team.description"
      :title="`${team.name}`"
      thumb="null"
  >
    <template #tags>
      <van-tag plain type="danger" style="margin-right: 8px; margin-top: 8px">
        {{
          teamStatusEnum[team.status]
        }}
      </van-tag>
    </template>

    <template #bottom>
      <div>
        {{ `队伍人数 :${team.hasJoinNum}/${team.maxNum}` }}
      </div>
      <div>
        {{ '过期时间' + team.expireTime }}
      </div>
      <div>
        {{ '创建时间' + team.createTime }}
      </div>
    </template>

    <template #footer>
      <van-button size="mini" type="primary" v-if="team.userId !== currentUser?.id || !team.hasJoinNum" plain
                  @click="preJoinTeam(team)">
        加入队伍
      </van-button>
      <van-button v-if="team.userId===currentUser?.id" size="mini" plain type="primary"
                  @click="doUpdateTeam(team.id)">更新队伍
      </van-button>
      <!--TODO 加入可见校验 -->
      <van-button v-if="team.userId!==currentUser?.id&&team.hasJoin" size="mini" plain type="primary"
                  @click="doQuitTeam(team.id)">退出队伍
      </van-button>
      <van-button v-if="team.userId===currentUser?.id" size="mini" plain type="primary"
                  @click="doDeleteTeam(team.id)">解散队伍
      </van-button>
      <van-dialog v-model:show="showPasswordDialog" title="请输入密码" show-cancel-button @confirm="doJoinTeam" @cancel="doJoinCancel">
        <van-field v-model="password" placeholder="请输入密码"/>
      </van-dialog>
    </template>
  </van-card>

</template>

<style scoped>

</style>