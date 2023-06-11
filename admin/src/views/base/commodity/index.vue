<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="仓库选择">
        <el-select v-model="form.repository" placeholder="请选择仓库">
          <el-option v-for="item in warehouseList" :key="item.id" :label="item.name" :value="item.name" />
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
      <el-form-item label="货品数量">
        <el-input v-model="form.number" placeholder="货品数量" />
      </el-form-item>
      <el-form-item v-if="allowEdit">
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { insertCommodity } from '@/api/commodity'
import { warehouseList } from '@/api/warehouse'

export default {
  data() {
    return {
      form: {
      },
      allowEdit: this.$store.getters.role === 1,
      warehouseList: []
    }
  },
  created() {
    warehouseList().then(res => {
      this.warehouseList = res.data
    })
  },
  methods: {
    onSubmit() {
      insertCommodity(this.form).then(() => {
        this.$message.success('添加货品信息成功')
      })
    },
    onCancel() {
      this.$message({
        message: 'cancel!',
        type: 'warning'
      })
    }
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
</style>

