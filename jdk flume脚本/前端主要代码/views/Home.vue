<!--主页-->
<template>
    <div class="wrapper3" >
        <el-row style="top: 100px;left: 450px;">
            <!--            <span>压力怪</span>-->
                <span style="font-weight:bold;font-size: 35px;" type="success">压力怪！程序猿的选择~</span>
        </el-row>
        <el-row style="top: 470px;left: 1000px;">
<!--            <span>压力怪</span>-->
            <el-button type="primary" round @click="$router.push('/User')">
                <i class="el-icon-d-arrow-right" style="font-weight:bold;font-size: 35px">开始使用</i>
            </el-button>
        </el-row>
    </div>
</template>


<script>
    export default {
        name: "Home",
    }
</script>

<style>
    .wrapper3 {
        height: 85vh;
        background:#fff url(../assets/t.webp) top left/1300px 650px no-repeat;
        /*repeat 10px 0px*/
        overflow: hidden;
    }
</style>
