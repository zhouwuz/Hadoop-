<!--集群页面-->
<template>
    <div>
        <div style="margin-bottom: 20px">
            <el-breadcrumb separator="/">
                <el-button type="info" style="font-size: 18px" @click="$router.push('/User')">
                    <i class="el-icon-back"></i>返回</el-button>
            </el-breadcrumb>
        </div>

        <div style="margin: 10px 0">
            <el-input style="width: 200px" placeholder="请输入主机名称" suffix-icon="el-icon-search" v-model="hostname"></el-input>
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
        </div>

        <div style="margin: 10px 0">
            <el-button type="warning" @click="handleAdd">新增主机<i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button type="primary" @click="pass">一键免密钥 <i class="el-icon-remove-outline"></i></el-button>
            <el-button type="primary" @click="jdk">一键JDK <i class="el-icon-remove-outline"></i></el-button>
            <el-button type="primary" @click="$router.push('/Download')">产品安装<i class="el-icon-download"></i></el-button>
            <el-button type="primary" @click="$router.push('/Validation')">产品验证<i class="el-icon-loading"></i></el-button>
        </div>

        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
            <el-table-column prop="id" label="序号" width="200">
            </el-table-column>
            <el-table-column prop="hostname" label="主机名" width="250">
            </el-table-column>
            <el-table-column prop="ip" label="IP" width="200">
            </el-table-column>
            <el-table-column prop="role" label="节点" width="245">
            </el-table-column>
            <el-table-column prop="password" label="主机密码" width="200">
            </el-table-column>
            <el-table-column label="操作"  width="200" align="center">
                <template slot-scope="scope">

                    <el-popconfirm
                        class="ml-5"
                        confirm-button-text='确定'
                        cancel-button-text='我再想想'
                        icon="el-icon-info"
                        icon-color="red"
                        title="您确定删除吗？"
                        @confirm="del(scope.row.id)"
                >
                    <el-button type="danger" slot="reference">删除主机<i class="el-icon-remove-outline"></i></el-button>
                </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>
        <!--翻页-->
        <div style="padding: 10px 0">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[2, 5, 10, 20]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>

        <el-dialog title="集群信息" :visible.sync="dialogFormVisible" width="30%" >
            <el-form label-width="80px" size="small">
                <el-form-item label="主机名">
                    <el-input v-model="form.hostname" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="IP">
                    <el-input v-model="form.ip" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="节点">
                    <el-input v-model="form.role" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="主机密码">
                    <el-input v-model="form.password" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="save">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "User",
        data() {
            return {
                tableData: [],
                total: 0,
                pageNum: 1,
                pageSize: 2,
                hostname: "",
                form: {},
                dialogFormVisible: false,
                headerBg: 'headerBg'
            }
        },
        created() {
            // 请求分页查询数据
            this.load()
        },
        methods: {
            load() {
                this.request.get("/host/page", {
                    params: {
                        pageNum: this.pageNum,
                        pageSize: this.pageSize,
                        hostname: this.hostname,
                    }
                }).then(res => {
                    console.log(res)
                    this.tableData = res.records
                    this.total = res.total

                })
            },
            handleAdd() {
                this.dialogFormVisible = true
                this.form = {}
            },
            save() {
                this.request.post("/host", this.form).then(res => {
                    if (res) {
                        this.$message.success("保存成功")
                        this.dialogFormVisible = false
                        this.load()
                    } else {
                        this.$message.error("保存失败")
                    }
                })
            },
            del(id) {
                this.request.delete("/host/" + id).then(res => {
                    if (res) {
                        this.$message.success("删除成功")
                        this.load()
                    } else {
                        this.$message.error("删除失败")
                    }
                })
            },
            handleSizeChange(pageSize) {
                console.log(pageSize)
                this.pageSize = pageSize
                this.load()
            },
            handleCurrentChange(pageNum) {
                console.log(pageNum)
                this.pageNum = pageNum
                this.load()
            },
            pass() {
                this.request.get("/pass").then(res => {
                    if(res.code === '200') {
                        this.$message.success("结果："+res.data)
                    } else {
                        this.$message.error("失败")
                    }
                })
            },
            jdk() {
                this.request.get("/jdk").then(res => {
                    if(res.code === '200') {
                        this.$message.success("结果："+res.data)
                    } else {
                        this.$message.error("失败")
                    }
                })
            },

        }
    }
</script>

<style>
    .headerBg {
        background: #eee!important;
    }
</style>
