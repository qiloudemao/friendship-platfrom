import {teamStatusEnum} from "../constants/team.ts";

export type teamType = {
    id: number;
    username:string;
    name: string;
    description: string;
    expireTime?: Date;
    maxNum: number;
    password?: string,
    // 定义枚举值类型，更规范
    status: teamStatusEnum;
    createTime: Date;
    updateTime: Date;
    createUser?: userType;
    hasJoinNum?: number;
};