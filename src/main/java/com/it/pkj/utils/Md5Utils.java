package com.it.pkj.utils;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.utils
 * @Author: kanimito
 * @CreateTime: 2025-03-23  13:32
 * @Description: TODO
 * @Version: 1.0
 */
import cn.hutool.crypto.digest.MD5;

/**
 * @author fir
 * @date 2024/7/22 10:07
 */
public class Md5Utils {


    public static void main(String[] args){

        // MD5取值
        String mPassword = MD5.create().digestHex("123456");
        String mPassword2 = MD5.create().digestHex("123456");
        if (mPassword.equals(mPassword2)) {
            System.out.println("密码正确");
        }
    }
}

