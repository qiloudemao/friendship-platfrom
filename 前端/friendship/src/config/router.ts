import Index from "../pages/Index.vue";
import TeamPage from "../pages/TeamPage.vue";
import UserPage from "../pages/UserPage.vue";
import SearchPage from "../pages/SearchPage.vue";
import UserEditPage from "../pages/UserEditPage.vue";
import SearchResultPage from "../pages/SearchResultPage.vue";
import UserLogin from "../pages/UserLoginPage.vue";
import TeamAddPage from "../pages/TeamAddPage.vue";
import TeamUpdatePage from "../pages/TeamUpdatePage.vue";
import TeamJoinPage from "../pages/TeamJoinPage.vue";
import TeamCreatePage from "../pages/TeamCreatePage.vue";
import UserUpdatePageVue from "../pages/UserUpdatePage.vue";


const routes = [
    {path: '/', component: Index},
    {path: '/team', title:'找队伍',component: TeamPage},
    {path: '/user',title:'个人信息', component: UserPage},
    {path: '/search', title:'搜索用户',component: SearchPage},
    {path: '/user/edit',title:'编辑用户信息', component: UserEditPage},
    {path: '/user/list',title:'用户列表', component: SearchResultPage},
    {path: '/user/login', title:'登录页面',component: UserLogin},
    {path: '/team/add',title:'添加队伍', component: TeamAddPage},
    {path: '/team/update',title:'更新队伍', component: TeamUpdatePage},
    {path:'/team/join',title:'加入队伍',component: TeamJoinPage},
    {path:'/team/create',title:'创建队伍',component: TeamCreatePage},
    {path:'/user/update',title:'更新用户信息',component: UserUpdatePageVue}
]

export default routes;