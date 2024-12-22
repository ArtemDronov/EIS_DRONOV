<template>
  <div id="app">
    <h1>Управление университетами</h1>
    <UniversityForm @refresh="refreshList" ref="form" />
    <UniversityList @edit="editUniversity" ref="list" />
  </div>
</template>

<script>
import UniversityForm from "@/components/UniversityForm.vue";
import UniversityList from "@/components/UniversityList.vue";

export default {
  components: {
    UniversityForm,
    UniversityList,
  },
  methods: {
    refreshList() {
      this.$refs.list.fetchUniversities();
    },
    editUniversity(university) {
      this.$refs.form.editUniversity(university);
    },
  },
};
</script>
