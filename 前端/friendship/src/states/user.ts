import myAXios from "../plugins/myAXios.ts";
// import { userType } from "../models/user.d.ts";}
//
// let currentUser: userType;
//
// const setCurrentUserState = (user: userType) => {
//     currentUser = user;
// }

export const getCurrentUser = async () => {
    //考虑做缓存，但是，修改后数据可能存在问题，保险，每次从后端直接拉去数据
    const res=await myAXios.get('/user/current');
    if (res.code === 200) {
        // setCurrentUserState(res.date);
        return res.data;
    }
    return null;
}

// export {
//     setCurrentUserState,
    // getCurrentUserState,
// }