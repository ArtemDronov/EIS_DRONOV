<template>
  <div>
    <h2>Список университетов</h2>
    <ul>
      <li v-for="university in universities" :key="university.id">
        {{ university.name }} ({{ university.location }}) - Студентов: {{ university.student_count }}
        Государственный: {{ university.is_public ? "Да" : "Нет" }}
        <button @click="$emit('edit', university)">Редактировать</button>
        <button @click="deleteUniversity(university.id)">Удалить</button>
      </li>
    </ul>
  </div>
</template>

<script>
import universityService from "@/services/universityService";

export default {
  data() {
    return {
      universities: [],
    };
  },
  methods: {
    async fetchUniversities() {
      this.universities = (await universityService.getUniversities()).data;
    },
    async deleteUniversity(id) {
      await universityService.deleteUniversity(id);
      this.fetchUniversities();
    },
  },
  mounted() {
    this.fetchUniversities();
  },
};
</script>
