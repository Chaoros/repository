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
      <el-table-column label="仓库">
        <template slot-scope="scope">
          {{ scope.row.repository }}
        </template>
      </el-table-column>
      <el-table-column label="货品编码">
        <template slot-scope="scope">
          {{ scope.row.coding }}
        </template>
      </el-table-column>
      <el-table-column label="货品类别">
        <template slot-scope="scope">
          {{ scope.row.category }}
        </template>
      </el-table-column>
      <el-table-column label="货品名称">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="规格型号">
        <template slot-scope="scope">
          {{ scope.row.model }}
        </template>
      </el-table-column>
      <el-table-column label="单位">
        <template slot-scope="scope">
          {{ scope.row.unit }}
        </template>
      </el-table-column>
      <el-table-column label="货品数量">
        <template slot-scope="scope">
          {{ scope.row.number }}
        </template>
      </el-table-column>

    </el-table>

  </div>
</template>

<script>
import { commodityList, delCommodity, insertCommodity } from '@/api/commodity'

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
      searchInput: ''
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      commodityList().then(response => {
        this.list = response.data.filter(item => {
          return item.number < 10
        })
        this.searchList()
        this.listLoading = false
      })
    },
    handleDelete(id) {
      delCommodity(id).then(() => {
        this.$message.success('删除成功')
        this.fetchData()
      })
    },
    clickUpdate(row) {
      this.form = { ...row }
      this.visible = true
    },
    handleUpdate() {
      insertCommodity(this.form).then(() => {
        this.$message.success('修改货品信息成功')
        this.visible = false
        this.fetchData()
      })
    },
    searchList() {
      this.list2 = this.list.filter(item => {
        return item.name.match(this.searchInput)
      })
    }
  }
}
</script>
