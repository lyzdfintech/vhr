<template>
    <div>
        <div>
            <div style="display: flex;justify-content: space-between">
                <div>
                    <el-input placeholder="请输入需求名称进行搜索，可以直接回车搜索..." prefix-icon="el-icon-search"
                              clearable
                              @clear="initEmps"
                              style="width: 350px;margin-right: 10px" v-model="keyword"
                              @keydown.enter.native="initEmps" ></el-input>
                    <el-button icon="el-icon-search" type="primary" @click="initEmps" >
                        搜索
                    </el-button>
                </div>
                <div>
                    <el-button type="primary" icon="el-icon-plus" @click="showAddEmpView">
                        添加需求
                    </el-button>
                </div>
            </div>
        </div>
        <div style="margin-top: 10px">
            <el-table
                    :data="emps"
                    stripe
                    border
                    v-loading="loading"
                    element-loading-text="正在加载..."
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(0, 0, 0, 0.8)"
                    style="width: 100%">
                <el-table-column
                        prop="name"
                        label="名称">
                </el-table-column>
                <el-table-column
                        prop="milestone"
                        label="所属版本"
                        :formatter="formatMilestone">
                </el-table-column>
                <el-table-column
                        prop="owner"
                        label="开发负责人"
                        :formatter="formatDeveloper">
                </el-table-column>
                <el-table-column
                        prop="client"
                        label="客户端"
                        :formatter="formatClient">
                </el-table-column>
                <el-table-column
                        prop="resource"
                        label="离线资源"
                        :formatter="formatResource">
                </el-table-column>
                <el-table-column
                        prop="service"
                        label="微服务"
                        :formatter="formatService">
                </el-table-column>
                <el-table-column
                        prop="state"
                        label="状态"
                        :formatter="formatState">
                </el-table-column>
                <el-table-column
                        prop="descriptor"
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
                        <el-button @click="showEditEmpView(scope.row)" style="padding: 3px" size="mini">编辑</el-button>
                        <el-button @click="deleteEmp(scope.row)" style="padding: 3px" size="mini" type="danger">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div style="display: flex;justify-content: flex-end">
                <el-pagination
                        background
                        @current-change="currentChange"
                        @size-change="sizeChange"
                        layout="sizes, prev, pager, next, jumper, ->, total, slot"
                        :total="total">
                </el-pagination>
            </div>
        </div>
        <el-dialog
                :title="title"
                :visible.sync="dialogVisible"
                width="330px">
            <div>
                <el-form :model="emp" :rules="rules" ref="empForm" label-width="100px">
                    <el-form-item label="名称">
                        <el-input  prefix-icon="el-icon-edit" v-model="emp.name"
                                  placeholder="请输入需求名称"></el-input>
                    </el-form-item>
                    <el-form-item label="所属版本">
                        <el-select v-model="emp.milestone" placeholder="请选择所属版本">
                            <el-option
                                    v-for="item in milestoneMap"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="开发负责人">
                        <el-select v-model="emp.owner" placeholder="请选择开发负责人">
                            <el-option
                                    v-for="item in developerMap"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="客户端">
                        <el-select v-model="emp.client" multiple placeholder="请选择客户端">
                            <el-option
                                    v-for="item in clientList"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="离线资源">
                        <el-select v-model="emp.resource" multiple placeholder="请选择离线资源">
                            <el-option
                                    v-for="item in resourceMap"
                                    :key="item.id"
                                    :label="item.resourceId"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="微服务">
                        <el-select v-model="emp.service" multiple placeholder="请选择微服务">
                            <el-option
                                    v-for="item in serviceMap"
                                    :key="item.id"
                                    :label="item.serviceId"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="需求状态">
                        <el-select v-model="emp.state" placeholder="请选择需求状态">
                            <el-option
                                    v-for="item in stateList"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="描述信息">
                        <el-input type="textarea" prefix-icon="el-icon-edit" v-model="emp.descriptor"
                                  placeholder="请输入描述信息"></el-input>
                    </el-form-item>
                </el-form>
            </div>
            <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="doAddEmp">确 定</el-button>
  </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "EmpBasic",
        data() {
            return {
                title: '',
                emps: [],
                testList: [],
                loading: false,
                loadingCount: 0,
                dialogVisible: false,
                total: 0,
                page: 1,
                keyword: '',
                size: 10,
                emp: {
                    milestone:1,
                    owner:1,
                    client:[],
                    resource:[],
                    service:[],
                    state:1,
                    descriptor:''
                },
                milestoneMap: {},
                developerMap: {},
                resourceMap: {},
                serviceMap: {},
                clientMap: {
                    1: 'Android',
                    2: 'iOS'
                },
                clientList: [
                    {id:1, name:'Android'},
                    {id:2, name:'iOS'}
                ],
                stateList : [
                    {id:0, name:'未启动'},
                    {id:1, name:'开发中'},
                    {id:2, name:'测试中'},
                    {id:3, name:'测试未通过'},
                    {id:4, name:'测试通过'},
                    {id:5, name:'需求终止'}
                ],
                rules: {
                    name: [{required: true, message: '请输入用户名', trigger: 'blur'}],
                    milestone: [{required: true, message: '请选择版本', trigger: 'blur'}],
                    owner: [{required: true, message: '请选择开发负责人', trigger: 'blur'}],
                    client: [{required: false, message: '请选择客户端', trigger: 'blur'}],
                    resource: [{required: false, message: '请选择离线资源', trigger: 'blur'}],
                    service: [{required: false, message: '请选择微服务', trigger: 'blur'}],
                    state: [{required: false, message: '请选择状态', trigger: 'blur'}],
                    descriptor: [{required: false, message: '输入描述信息', trigger: 'blur'}]
                }
            }
        },
        mounted() {
            this.getRequest('/um/developer/?page=1&size=9999999').then(resp => {
                if (resp) {
                    for (var i = 0; i < resp.data.length; i++) {
                        var element = resp.data[i];
                        this.developerMap[element.id] = element;
                    }
                }
                console.log(this.developerMap)
            });

            this.getRequest('/ac/milestone/').then(resp => {
                if (resp) {
                    for (var i = 0; i < resp.data.length; i++) {
                        var element = resp.data[i];
                        this.milestoneMap[element.id] = element;
                    }
                }
                console.log(this.milestoneMap)
            });

            this.getRequest('/ac/resource/').then(resp => {
                if (resp) {
                    for (var i = 0; i < resp.data.length; i++) {
                        var element = resp.data[i];
                        this.resourceMap[element.id] = element;
                    }
                }
                console.log(this.resourceMap)
            });

            this.getRequest('/ac/service/').then(resp => {
                if (resp) {
                    for (var i = 0; i < resp.data.length; i++) {
                        var element = resp.data[i];
                        this.serviceMap[element.id] = element;
                    }
                }
                console.log(this.serviceMap)
            });
            this.initEmps();
        },
        methods: {
            emptyEmp() {
                this.emp = {}
            },
            showEditEmpView(data) {
                this.title = '编辑需求信息';
                this.emp = data;
                this.dialogVisible = true;
            },
            deleteEmp(data) {
                this.$confirm('此操作将永久删除【' + data.name + '】, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/pm/requirement/" + data.id).then(resp => {
                        if (resp) {
                            this.initEmps();
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            doAddEmp() {
                if (this.emp.id) {
                    this.$refs['empForm'].validate(valid => {
                        if (valid) {
                            this.putRequest("/pm/requirement/", this.emp).then(resp => {
                                if (resp) {
                                    this.dialogVisible = false;
                                    this.initEmps();
                                }
                            })
                        }
                    });
                } else {
                    this.$refs['empForm'].validate(valid => {
                        if (valid) {
                            this.postRequest("/pm/requirement/", this.emp).then(resp => {
                                if (resp) {
                                    this.dialogVisible = false;
                                    this.initEmps();
                                }
                            })
                        }
                    });
                }
            },
            sizeChange(currentSize) {
                this.size = currentSize;
                this.initEmps();
            },
            currentChange(currentPage) {
                this.page = currentPage;
                this.initEmps();
            },
            showAddEmpView() {
                this.emptyEmp();
                this.title = '添加需求';
                this.dialogVisible = true;
            },
            initEmps() {
                this.loading = true;
                let url = '/pm/requirement/?page=' + this.page + '&size=' + this.size + "&name=" + this.keyword;
                this.getRequest(url).then(resp => {
                    this.loading = false;
                    if (resp) {
                        this.emps = resp.data;
                        this.total = resp.total;
                    }
                });
            },
            formatDeveloper(row, column) {
                console.log(row.owner)
                console.log(this.developerMap)
                return this.developerMap[row.owner].name;
            },
            formatMilestone(row, column) {
                console.log(row.milestone)
                console.log(this.milestoneMap)
                return this.milestoneMap[row.milestone].name;
            },
            formatClient(row, column) {
                console.log(row.client);
                console.log(this.clientMap);
                if (row.client) {
                    var idArray = [];
                    console.log(idArray);
                    for (var i = 0; i < row.client.length; i++) {
                        idArray[i] = this.clientMap[row.client[i]];
                    }
                    console.log(idArray);
                    return idArray.join('|');
                } else {
                    return "";
                }
            },
            formatResource(row, column) {
                console.log(row.resource);
                console.log(this.resourceMap);
                if (row.resource) {
                    var idArray = [];
                    console.log(idArray);
                    for (var i = 0; i < row.resource.length; i++) {
                        idArray[i] = this.resourceMap[row.resource[i]].resourceId;
                    }
                    console.log(idArray);
                    return idArray.join('|');
                } else {
                    return "";
                }
            },
            formatService(row, column) {
                console.log(row.service);
                console.log(this.serviceMap);
                if (row.service) {
                    var idArray = [];
                    console.log(idArray);
                    for (var i = 0; i < row.service.length; i++) {
                        idArray[i] = this.serviceMap[row.service[i]].serviceId;
                    }
                    console.log(idArray);
                    return idArray.join('|');
                } else {
                    return "";
                }
            },
            formatState(row, column) {
                //需求状态（0:未启动 1:开发中 2:测试中 3:测试未通过 4:测试通过 5:需求终止）
                console.log(row.state);
                if (row.state == 0) {
                    return "未启动";
                } else if (row.state == 1) {
                    return "开发中";
                } else if (row.state == 2) {
                    return "测试中";
                } else if (row.state == 3) {
                    return "测试未通过";
                } else if (row.state == 4) {
                    return "测试通过";
                } else if (row.state == 5) {
                    return "需求终止";
                } else {
                    return "未知";
                }
            },
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