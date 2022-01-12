package com.lombok;

public class CheckBuilder {

    String packagePrivateField;
    private String privateField;
    protected String protectedField;
    public String publicField;

    CheckBuilder(String packagePrivateField, String privateField, String protectedField, String publicField) {
        this.packagePrivateField = packagePrivateField;
        this.privateField = privateField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    public static CheckBuilderBuilder builder() {
        return new CheckBuilderBuilder();
    }

    public static class CheckBuilderBuilder {
        private String packagePrivateField;
        private String privateField;
        private String protectedField;
        private String publicField;

        CheckBuilderBuilder() {
        }

        public CheckBuilderBuilder packagePrivateField(String packagePrivateField) {
            this.packagePrivateField = packagePrivateField;
            return this;
        }

        public CheckBuilderBuilder privateField(String privateField) {
            this.privateField = privateField;
            return this;
        }

        public CheckBuilderBuilder protectedField(String protectedField) {
            this.protectedField = protectedField;
            return this;
        }

        public CheckBuilderBuilder publicField(String publicField) {
            this.publicField = publicField;
            return this;
        }

        public CheckBuilder build() {
            return new CheckBuilder(packagePrivateField, privateField, protectedField, publicField);
        }

        public String toString() {
            return "CheckBuilder.CheckBuilderBuilder(packagePrivateField=" + this.packagePrivateField + ", privateField=" + this.privateField + ", protectedField=" + this.protectedField + ", publicField=" + this.publicField + ")";
        }
    }
}
