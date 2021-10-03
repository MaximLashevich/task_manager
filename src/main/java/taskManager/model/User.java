package taskManager.model;

public class User<T> {
    private String name;
    private int age;
    private T id;

    public User(String name, int age, T id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public T getId() {
        return this.id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String template = "\n\nUser ID: %s\nName: %s\nAge: %d\n";
        System.out.printf(template, id, name, age);
        return template;
    }

    public static class Builder<T> {
        private String name;
        private int age;
        private T id;

        public Builder<T> name(String name) {
            this.name = name;
            return this;
        }

        public Builder<T> age(int age) {
            this.age = age;
            return this;
        }

        public Builder<T> id(T id) {
            this.id = id;
            return this;
        }

        public User<T> build() {
            return new User<>(name, age, id);
        }

    }
}
