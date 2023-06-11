<template>
  <div class="app-container">
    <el-form inline>
      <el-form-item label="仓库选择">
        <el-select v-model="repository" clearable placeholder="请选择仓库">
          <el-option v-for="item in warehouses" :key="item.id" :label="item.name" :value="item.name" />
        </el-select>
      </el-form-item>
      <el-form-item label="货物种类">
        <el-select v-model="category" clearable placeholder="请选择货物种类">
          <el-option label="普通货物" value="普通货物" />
          <el-option label="特殊货物" value="特殊货物" />
          <el-option label="件杂货物" value="件杂货物" />
          <el-option label="危险货物" value="危险货物" />
          <el-option label="散装货物" value="散装货物" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchList">搜索</el-button>
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
      <el-table-column v-if="allowEdit" label="操作" width="200">
        <template slot-scope="scope">
          <el-button
            type="primary"
            size="mini"
            @click="clickUpdate(scope.row)"
          >修改</el-button>
          <el-button
            type="danger"
            size="mini"
            @click="handleDelete(scope.row.id)"
          >删除</el-button>
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
    <el-dialog title="修改货品信息" :visible.sync="visible" width="30%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="仓库选择">
          <el-select v-model="form.repository" placeholder="请选择仓库">
            <el-option v-for="item in warehouses" :key="item.id" :label="item.name" :value="item.name" />
          </el-select>
        </el-form-item>
        <el-form-item label="货品编码">
          <el-input v-model="form.coding" placeholder="货品编码" />
        </el-form-item>
        <el-form-item label="货物种类">
          <el-select v-model="form.category" placeholder="请选择货物种类">
            <el-option label="普通货物" value="普通货物" />
            <el-option label="特殊货物" value="特殊货物" />
            <el-option label="件杂货物" value="件杂货物" />
            <el-option label="危险货物" value="危险货物" />
            <el-option label="散装货物" value="散装货物" />
          </el-select>
        <!-- <el-input v-model="form.category" placeholder="货品类别" /> -->
        </el-form-item>
        <el-form-item label="货品名称">
          <el-input v-model="form.name" placeholder="货品名称" />
        </el-form-item>
        <el-form-item label="规格型号">
          <el-input v-model="form.model" placeholder="规格型号" />
        </el-form-item>
        <el-form-item label="单位">
          <el-input v-model="form.unit" placeholder="单位" />
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
import { commodityList, delCommodity, insertCommodity } from '@/api/commodity'
import { warehouseList } from '@/api/warehouse'

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
      allowEdit: this.$store.getters.role === 1,
      pageSize: 10,
      pageNum: 1,
      warehouses: [],
      repository: '',
      category: ''
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
    warehouseList().then(res => {
      this.warehouses = res.data
    })
  },
  methods: {
    fetchData() {
      this.listLoading = true
      commodityList().then((response) => {
        this.list = response.data
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
      this.list2 = this.list.filter((item) => {
        return (
          item.category.match(this.category) &&
          item.repository.match(this.repository)
        )
      })
    }
  }
}
</script>
