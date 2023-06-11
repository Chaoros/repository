<template>
  <div class="app-container">
    <el-form :inline="true">
      <el-form-item>
        <el-date-picker
          v-model="searchDate"
          type="daterange"
          value-format="yyyy-MM-dd"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchList">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table
      v-loading="listLoading"
      :data="list3"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
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
      <el-table-column label="出库数量">
        <template slot-scope="scope">
          {{ scope.row.number }}
        </template>
      </el-table-column>
      <el-table-column label="出库时间">
        <template slot-scope="scope">
          {{ scope.row.repositoryTime }}
        </template>
      </el-table-column>
      <el-table-column label="操作人">
        <template slot-scope="scope">
          {{ scope.row.username }}
        </template>
      </el-table-column>
    </el-table>
    <div style="padding:20px;text-align:center">
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="pageSize"
        :total="list2.length"
        :current-page.sync="pageNum"
      />
    </div>
  </div>

</template>

<script>
import { repositoryList } from '@/api/repository'

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
      searchDate: undefined,
      list: [],
      list2: [],
      listLoading: true,
      pageSize: 10,
      pageNum: 1
    }
  },
  computed: {
    list3() {
      const result = []
      const start = this.pageSize * (this.pageNum - 1)

      for (let index = start; index < start + this.pageSize; index++) {
        if (this.list2[index]) {
          result.push(this.list2[index])
        }
      }

      return result
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      repositoryList(0).then(response => {
        this.list = response.data
        this.list2 = response.data
        this.listLoading = false
      })
    },
    searchList() {
      if (this.searchDate) {
        this.list2 = this.list.filter(item => {
          const startDate = new Date(this.searchDate[0])
          const endDate = new Date(this.searchDate[1])
          const iDate = new Date(item.repositoryTime)
          return iDate.getTime() > startDate.getTime() && iDate.getTime() < endDate.getTime()
        })
      }
    }
  }
}
</script>
