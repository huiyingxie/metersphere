<template>
  <el-dialog :close-on-click-modal="false"
             :destroy-on-close="true"
             @close = "close"
             title="关联TestIn项目组" width="600px"
             :visible.sync="loadFileVisible">
    <div style="line-height: 30px;">
      已关联TestIn项目组：{{ associatedProjGroup?associatedProjGroup.testInProjectId+' '+associatedProjGroup.testInProjectName:'无' }}
      <!-- <el-button @click="deleteAssociate" v-if="associatedProjGroup" size="small" type="primary" icon="el-icon-delete" circle></el-button> -->
    </div>
    <div>

    </div>
    <el-divider></el-divider>
    <el-table v-loading="loading"
              class="basic-config"
              row-key="projectid"
              :data="tableData"
              @row-click="tableRowClick">

        <el-table-column label="" width="50" align="center">
        <template slot-scope="scope">
          <!-- {{&nbsp;}} 或者 {{""}}-->
          <el-radio v-model="currentProjectGroup" :label="scope.row.projectid">{{""}}</el-radio>
        </template>
      </el-table-column>
      <el-table-column
        prop="projectid"
        label="id">
      </el-table-column>
      <el-table-column
        prop="name"
        label="项目组名称">
      </el-table-column>
      <!-- <el-table-column
        prop="descr"
        label="描述">
      </el-table-column> -->
      <!-- <el-table-column
        prop="status"
        label="状态">

      </el-table-column> -->
      <!-- <el-table-column
        :label="$t('load_test.last_modify_time')">
        <template v-slot:default="scope">
          <i class="el-icon-time"/>
          <span class="last-modified">{{ scope.row.updateTime | timestampFormatDate }}</span>
        </template>
      </el-table-column> -->
    </el-table>
    <ms-table-pagination :change="getProjectFiles" :current-page.sync="currentPage" :page-size.sync="pageSize"
                         :total="total"/>
                         <span slot="footer" class="dialog-footer">
    <el-button @click="close">取 消</el-button>
    <el-button type="primary" @click="submit">确 定</el-button>
  </span>

  </el-dialog>
</template>

<script>
import MsTablePagination from "@/business/components/common/pagination/TablePagination";
import axios from "axios";
export default {
  name: "AssociatedProj",
  components: {
    MsTablePagination
  },
  data() {
    return {
      loadFileVisible: false,
      loading:false,
      currentPage: 1,
      pageSize: 5,
      total: 0,
      tableData: [],
      // condition: {},
      currentProjectGroup:null,
      currentProjectName:null,
      associatedProjGroup:null,
    };
  },
  methods: {
    open(project) {
      // console.log('project',project);
      this.projectId = project.id;
      this.loadFileVisible = true;
      this.getAssociatedProj();
      this.getProjectFiles();
    },
    close() {
      this.loadFileVisible = false;
      this.currentProjectGroup = null;
      this.currentProjectName = null;
      this.associatedProjGroup = null
    },
    tableRowClick(row, column, event){
      this.currentProjectGroup = row.projectid
      this.currentProjectName = row.name
      this.associatedProjGroup = {
        testInProjectId:row.projectid,
        testInProjectName:row.name
      }
    },
    getAssociatedProj(){
      this.$get('/testIn/project/getBind?msProjectId=' + this.projectId, res => {
        let data = res.data;
        this.associatedProjGroup = data
        if(data)this.currentProjectGroup = data.testInProjectId
        // console.log('res',data);
      });
    },
    getProjectFiles() {
      this.loading = true
    //   axios.post('/msProjectTestinProjectTeam/list/' + this.currentPage + "/" + this.pageSize, this.condition).then(res => {
    //     let data = res.data;
    //     this.total = data.totalCount;
    //     this.tableData = data.data;
    //     this.loading = false;
    //     console.log('res',data);
    // })
    this.$get('/testIn/project/list/'+ this.currentPage + "/" + this.pageSize, res => {
      let data = res.data;
        this.total = data.itemCount;
        this.tableData = data.listObject;
        this.loading = false;
        console.log('res',data);
      });
      // this.projectLoadingResult = this.$post('/msProjectTestinProjectTeam/list/' + this.currentPage + "/" + this.pageSize, this.condition, res => {
      //   let data = res.data;
      //   // this.total = data.itemCount;
      //   this.tableData = data;
      //   console.log('res',res);
      // });
    },
    // deleteAssociate(){
      
    // },
    submit(){
      let param = {
        "msProjectId": this.projectId,
        "testInProjectId": this.currentProjectGroup,
        "testInProjectName": this.currentProjectName
      }
      this.$post('/testIn/project/bind', param, res => {
        let data = res;
        if(data.success){
          this.$message.success('关联成功');
          this.close()
        }else{
          this.$message.success('关联失败，请重试');
        }
        // this.total = data.itemCount;
        // this.tableData = data;
        console.log('res',res);
      });
    }
  }
};
</script>

<style scoped>

</style>
