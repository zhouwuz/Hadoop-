<!--主控制页面-->
<template>

    <el-container style="min-height: 100vh">

        <el-aside :width="sideWidth + 'px'" style="box-shadow: 10px 0 6px rgb(0 21 41);">
            <Aside :isCollapse="isCollapse" :logoTextShow="logoTextShow" />
        </el-aside>


        <el-container>
            <el-header style="border-bottom: 1px solid #ccc;">
                <Header :collapseBtnClass="collapseBtnClass" />
            </el-header>
            <el-main>
<!--        表示当前页面的子路由会在 <router-view /> 里面展示-->
                <router-view />
            </el-main>
        </el-container>
    </el-container>

</template>

<script>
    import Aside from "@/components/Aside";
    import Header from "@/components/Header";
    export default {
        name: 'Home',
        data() {
            return {

                collapseBtnClass: 'el-icon-s-fold',
                isCollapse: false,
                sideWidth: 200,
                logoTextShow: true,

            }
        },
        components: {
            Aside,
            Header
        },
        methods: {


        }
    }
</script>


