<!--导航栏-->
<template>
    <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x: hidden"
             background-color="rgb(48, 65, 86)"
             text-color="#fff"
             active-text-color="#3DA6CC"
             :collapse-transition="false"
             :collapse="isCollapse"
             router
    >
        <div style="height: 60px; line-height: 60px; text-align: center">
            <img src="../assets/压力.png" alt="" style="width: 27px; position: relative; top: 5px; right: 5px">
            <b style="color: white" v-show="logoTextShow">Hadoop|压力怪</b>
        </div>

        <el-menu-item index="/">
            <template slot="title">
            <i class="el-icon-s-home"></i>
            <span slot="title">首页</span>
            </template>
        </el-menu-item>

        <el-submenu index="1">
            <template slot="title">
                <i class="el-icon-menu"></i>
                <span slot="title">集群概览</span>
            </template>
            <el-menu-item index="/user">
                <i class="el-icon-s-custom"></i>
                <span slot="title">集群展示</span>
            </el-menu-item>
            <el-menu-item index="/Download">
                <i class="el-icon-download"></i>
                <span slot="title">产品安装</span>
            </el-menu-item>

            <el-menu-item index="/Validation">
                <i class="el-icon-loading"></i>
                <span slot="title">产品验证</span>
            </el-menu-item>
        </el-submenu>



    </el-menu>
</template>

<script>
    export default {
        name: "Aside",
        props: {
            isCollapse: Boolean,
            logoTextShow: Boolean
        }
    }
</script>

<style scoped>

</style>
