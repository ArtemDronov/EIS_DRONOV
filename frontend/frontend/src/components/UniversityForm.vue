<template>
  <div>
    <h2>Добавить/Обновить университет</h2>
    <form @submit.prevent="submitUniversity">
      <input v-model="university.name" placeholder="Название университета" required />
      <input v-model="university.location" placeholder="Расположение" required />
      <input
          v-model.number="university.student_count"
          type="number"
          placeholder="Количество студентов"
          required
      />
      <label>
        Государственный:
        <input
            type="checkbox"
            v-model="university.is_public"
            @change="updateIsPublic"
        />
      </label>
      <button type="submit">Сохранить</button>
    </form>
  </div>
</template>

<script>
import universityService from "@/services/universityService";

export default {
  data() {
    return {
      university: {
        id: null,
        name: "",
        location: "",
        student_count: 0,
        is_public: false,
      },
    };
  },
  methods: {
    updateIsPublic(event) {
      this.university.is_public = event.target.checked || false;
    },
    async submitUniversity() {
      this.university.is_public = !!this.university.is_public;
      if (this.university.id) {
        await universityService.updateUniversity(this.university);
      } else {
        await universityService.addUniversity(this.university);
      }
      this.clearForm();
      this.$emit("refresh");
    },
    clearForm() {
      this.university = {
        id: null,
        name: "",
        location: "",
        student_count: 0,
        is_public: false,
      };
    },
    editUniversity(university) {
      this.university = { ...university };
    },
  },
};
</script>
