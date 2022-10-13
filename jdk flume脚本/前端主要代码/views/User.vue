<!--集群页面-->
<template>
    <div>
        <div style="margin-bottom: 20px">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item style="font-size: 18px;font-weight:bold">集群概览</el-breadcrumb-item>
            </el-breadcrumb>
        </div>

        <div style="margin: 10px 0">
            <el-input style="width: 200px" placeholder="请输入集群名称" suffix-icon="el-icon-search" v-model="username"></el-input>
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
        </div>

        <div style="margin: 10px 0">
            <el-button type="warning" @click="handleAdd">新增集群<i class="el-icon-circle-plus-outline"></i></el-button>
            <!--                    <el-button type="primary">一键免密钥 <i class="el-icon-remove-outline"></i></el-button>-->
            <!--                    <el-button type="primary">导入 <i class="el-icon-bottom"></i></el-button>-->
            <!--                    <el-button type="primary">导出 <i class="el-icon-top"></i></el-button>-->
        </div>

        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
            <el-table-column prop="id" label="序号" width="200">
            </el-table-column>
            <el-table-column prop="username" label="用户名" width="250">
            </el-table-column>
            <el-table-column prop="password" label="密码" width="200">
            </el-table-column>
            <el-table-column prop="name" label="集群名字" width="245">
            </el-table-column>
            <el-table-column prop="number" label="主机数" width="200">
            </el-table-column>
            <el-table-column label="操作"  width="200" align="center">
                <template slot-scope="scope">
                    <el-button type="success" @click="$router.push('/Jiqun1')">进入 <i class="el-icon-edit"></i></el-button><el-popconfirm
                        class="ml-5"
                        confirm-button-text='确定'
                        cancel-button-text='我再想想'
                        icon="el-icon-info"
                        icon-color="red"
                        title="您确定注销吗？"
                        @confirm="del(scope.row.id)"
                >
                    <el-button type="danger" slot="reference">注销集群 <i class="el-icon-remove-outline"></i></el-button>
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
<!--            <el-form label-width="80px" size="small">-->
<!--                <el-form-item label="用户名">-->
<!--                    <el-input v-model="form.username" autocomplete="off"></el-input>-->
<!--                </el-form-item>-->
<!--                <el-form-item label="密码">-->
<!--                    <el-input v-model="form.password" autocomplete="off"></el-input>-->
<!--                </el-form-item>-->
<!--                <el-form-item label="集群名字">-->
<!--                    <el-input v-model="form.name" autocomplete="off"></el-input>-->
<!--                </el-form-item>-->
<!--                <el-form-item label="主机数">-->
<!--                    <el-input v-model="form.number" autocomplete="off"></el-input>-->
<!--                </el-form-item>-->
<!--            </el-form>-->
            <h1>不好意思功能为完善请退出注册去创建新的集群！！！</h1>
            <div slot="footer" class="dialog-footer">
<!--                <el-button @click="dialogFormVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
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
                username: "",
                form: {},
                user: {},
                rules: {username: []},
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
                this.request.get("/user/page", {
                    params: {
                        pageNum: this.pageNum,
                        pageSize: this.pageSize,
                        username: this.username,
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
                this.request.post("/user", this.form).then(res => {
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
                this.request.delete("/user/" + id).then(res => {
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
            }
        }
    }
</script>
