<template>
  <div class="app-container">
    <el-form inline>
      <el-form-item label="搜索">
        <el-input v-model="searchInput" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchList">搜索</el-button>
      </el-form-item>

    </el-form>
    <el-table
      v-loading="listLoading"
      :data="list2"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="客户名称" align="center">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="客户地址" align="center">
        <template slot-scope="scope">
          {{ scope.row.address }}
        </template>
      </el-table-column>
      <el-table-column v-if="allowEdit" label="操作" width="200">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="clickUpdate(scope.row)">修改</el-button>
          <el-button type="danger" size="mini" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      title="客户信息"
      :visible.sync="visible"
      width="30%"
    >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="客户名称">
          <el-input v-model="form.name" placeholder="姓名" />
        </el-form-item>
        <el-form-item label="客户地址">
          <el-input v-model="form.address" placeholder="省市" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="visible = false">关闭</el-button>
        <el-button type="primary" @click="handleUpdate">提交</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { customerList, delCustomer, saveCustomer } from '@/api/customer'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: [],
      list2: [],
      listLoading: true,
      visible: false,
      form: {},
      searchInput: '',
      allowEdit: true
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      customerList().then(response => {
        this.list = response.data
        this.searchList()
        this.listLoading = false
      })
    },
    handleDelete(id) {
      delCustomer(id).then(() => {
        this.$message.success('删除成功')
        this.fetchData()
      })
    },
    clickUpdate(row) {
      this.form = { ...row }
      this.visible = true
    },
    // clickInsert() {
    //   this.form = {}
    //   this.visible = true
    // },
    handleUpdate() {
      saveCustomer(this.form).then(() => {
        this.$message.success('修改客户信息成功')
        this.visible = false
        this.fetchData()
      })
    },
    searchList() {
      this.list2 = this.list.filter(item => {
        return item.name.match(this.searchInput) || item.address.match(this.searchInput)
      })
    }
  }
}
</script>
