<template>
    <div class="wrapper5">
        <div class="position" style="font-size: 30px;
        font-weight: 600;">产品安装</div>
        <el-row style="left: 100px;top: 70px">

            <el-col :span="4" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
                <el-card :body-style="{ padding: '0px' }">
                    <img src="https://img1.baidu.com/it/u=95124979,3839771761&fm=253&fmt=auto&app=138&f=JPEG?w=831&h=500" class="image">
                    <div style="padding: 14px;">
                        <span>Hadoop</span>
                        <div class="bottom clearfix">
                            <el-button style="font-size: 18px" type="primary" class="button" @click="hadoop">安装</el-button>
                        </div>
                    </div>
                </el-card>
            </el-col>
            <el-col :span="4" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
                <el-card :body-style="{ padding: '0px' }">
                    <img src="https://img1.baidu.com/it/u=95124979,3839771761&fm=253&fmt=auto&app=138&f=JPEG?w=831&h=500" class="image">
                    <div style="padding: 14px;">
                        <span>Zookeeper</span>
                        <div class="bottom clearfix">
                            <el-button style="font-size: 18px" type="primary" class="button" @click="zookeeper">安装</el-button>
                        </div>
                    </div>
                </el-card>
            </el-col>
            <el-col :span="4" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
                <el-card :body-style="{ padding: '0px' }">
                    <img src="https://img1.baidu.com/it/u=95124979,3839771761&fm=253&fmt=auto&app=138&f=JPEG?w=831&h=500" class="image">
                    <div style="padding: 14px;">
                        <span>Kafka</span>
                        <div class="bottom clearfix">
                            <el-button style="font-size: 18px" type="primary" class="button" @click="kafka">安装</el-button>
                        </div>
                    </div>
                </el-card>
            </el-col>
        </el-row>

    </div>
</template>

<script>
    export default {
        data() {

        },
        methods: {
            hadoop() {
                this.request.get("/hadoop").then(res => {
                    if(res.code === '200') {
                        this.$alert('结果：'+res.data, '安装结果', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                        });
                        // this.$message.success("成功："+res.data)
                    } else {
                        this.$message.error("失败")
                    }
                })
            },
            zookeeper() {
                this.request.get("/zookeeper").then(res => {
                    if(res.code === '200') {
                        this.$alert('结果：'+res.data, '安装结果', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                        });
                        // this.$message.success("成功："+res.data)
                    } else {
                        this.$message.error("失败")
                    }
                })
            },
            kafka() {
                this.request.get("/kafka").then(res => {
                    if(res.code === '200') {
                        this.$alert('结果：'+res.data, '安装结果', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                        });
                        // this.$message.success("成功："+res.data)
                    } else {
                        this.$message.error("失败")
                    }
                })
            },

        }
    };
</script>
<style scoped>
    .time {
        font-size: 13px;
        color: #999;
    }

    .bottom {
        margin-top: 13px;
        line-height: 12px;
    }

    .button {
        padding: 0;
        float: right;
    }

    .image {
        width: 100%;
        display: block;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }
</style>
<style>
    .wrapper5 {
        height: 85vh;
        background-image: linear-gradient(to bottom right, #C6F0F6 , #C6F0F6);
        overflow: hidden;
    }
</style>
