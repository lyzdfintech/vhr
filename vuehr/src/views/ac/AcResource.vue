<template>
    <div>
        <div>
            <div style="text-align: right">
                <el-button type="primary" icon="el-icon-plus" @click="showAddRowView">
                    添加离线资源
                </el-button>
            </div>
        </div>
        <div style="margin-top: 10px">
            <el-table
                    :data="rows"
                    stripe
                    border
                    v-loading="loading"
                    element-loading-text="正在加载..."
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(0, 0, 0, 0.8)"
                    style="width: 100%">
                <el-table-column
                        prop="resourceId"
                        label="离线资源ID">
                </el-table-column>
                <el-table-column
                        prop="resourceDesc"
                        label="描述信息">
                </el-table-column>
                <el-table-column
                        prop="gmtCreate"
                        label="创建时间">
                </el-table-column>
                <el-table-column
                        prop="gmtModified"
                        label="上次修改时间">
                </el-table-column>
                <el-table-column
                        label="操作">
                    <template slot-scope="scope">
                        <el-button @click="showEditRowView(scope.row)" style="padding: 3px" size="mini">编辑</el-button>
                        <el-button @click="deleteRow(scope.row)" style="padding: 3px" size="mini" type="danger">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <el-dialog
                :title="title"
                :visible.sync="dialogVisible"
                width="360px">
            <div>
                <el-form :model="row" :rules="rules" ref="rowForm">
                    <el-row>
                        <el-form-item label="离线资源ID:" prop="resourceId">
                            <el-input size="mini" style="width: 200px" prefix-icon="el-icon-edit" v-model="row.resourceId"
                                      placeholder="请输入环境名称"></el-input>
                        </el-form-item>
                    </el-row>
                    <el-row>
                        <el-form-item label="描述信息:" prop="resourceDesc">
                            <el-input size="mini" style="width: 200px" prefix-icon="el-icon-edit" v-model="row.resourceDesc"
                                      placeholder="请输入描述信息"></el-input>
                        </el-form-item>
                    </el-row>
                </el-form>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="doAddRow">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "RowBasic",
        data() {
            return {
                title: '',
                rows: [],
                loading: false,
                dialogVisible: false,
                row: {
                    resourceId: "20180001",
                    resourceDesc: "20180001"
                },
                defaultProps: {
                    children: 'children',
                    label: 'name'
                },
                rules: {
                    resourceId: [{required: true, message: '请输入离线资源ID', trigger: 'blur'}],
                    resourceDesc: [{required: true, message: '请输入描述信息', trigger: 'blur'}]
                }
            }
        },
        mounted() {
            this.initRows();
        },
        methods: {
            emptyRow() {
                this.row = {
                    resourceId: "",
                    resourceDesc: ""
                }
            },
            showEditRowView(data) {
                this.title = '编辑离线资源信息';
                this.row = data;
                this.dialogVisible = true;
            },
            deleteRow(data) {
                this.$confirm('此操作将永久删除【' + data.resourceId + '】, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/ac/resource/" + data.id).then(resp => {
                        if (resp) {
                            this.initRows();
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            doAddRow() {
                if (this.row.id) {
                    this.$refs['rowForm'].validate(valid => {
                        if (valid) {
                            this.putRequest("/ac/resource", this.row).then(resp => {
                                if (resp) {
                                    this.dialogVisible = false;
                                    this.initRows();
                                }
                            })
                        }
                    });
                } else {
                    this.$refs['rowForm'].validate(valid => {
                        if (valid) {
                            this.postRequest("/ac/resource", this.row).then(resp => {
                                if (resp) {
                                    this.dialogVisible = false;
                                    this.initRows();
                                }
                            })
                        }
                    });
                }
            },
            showAddRowView() {
                this.emptyRow();
                this.title = '添加离线资源';
                this.dialogVisible = true;
            },
            initRows() {
                this.loading = true;
                let url = '/ac/resource';
                this.getRequest(url).then(resp => {
                    this.loading = false;
                    if (resp) {
                        this.rows = resp.data;
                        this.total = resp.total;
                    }
                });
            }
        }
    }
</script>

<style>
    /* 可以设置不同的进入和离开动画 */
    /* 设置持续时间和动画函数 */
    .slide-fade-enter-active {
        transition: all .8s ease;
    }

    .slide-fade-leave-active {
        transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
    }

    .slide-fade-enter, .slide-fade-leave-to
        /* .slide-fade-leave-active for below version 2.1.8 */
    {
        transform: translateX(10px);
        opacity: 0;
    }
</style>