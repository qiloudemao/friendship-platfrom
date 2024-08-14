import axios from "axios";

const myAXios=axios.create({
    baseURL:'http://localhost:8080',
})

myAXios.defaults.withCredentials = true;
//拦截器
// 添加请求拦截器
myAXios.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    // console.log("请求发送了",config)
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

// 添加响应拦截器
myAXios.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    // console.log("请求收到了了",response)
    if(response?.data?.code === 40100) {
        const redirectUrl=window.location.href;
        window.location.href=`/user/login?redirect=${redirectUrl}`;
    }
    return response.data;
}, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
});

export default myAXios