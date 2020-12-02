package com.bpn8adh.bankaksassessment.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ApiResponseModel implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("result")
    @Expose
    private Result result;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }


    public class Field implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("placeholder")
        @Expose
        private String placeholder;
        @SerializedName("regex")
        @Expose
        private String regex;
        @SerializedName("type")
        @Expose
        private Type type;
        @SerializedName("is_mandatory")
        @Expose
        private String isMandatory;
        @SerializedName("hint_text")
        @Expose
        private String hintText;
        @SerializedName("ui_type")
        @Expose
        private UiType uiType;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }

        public String getRegex() {
            return regex;
        }

        public void setRegex(String regex) {
            this.regex = regex;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public String getIsMandatory() {
            return isMandatory;
        }

        public void setIsMandatory(String isMandatory) {
            this.isMandatory = isMandatory;
        }

        public String getHintText() {
            return hintText;
        }

        public void setHintText(String hintText) {
            this.hintText = hintText;
        }

        public UiType getUiType() {
            return uiType;
        }

        public void setUiType(UiType uiType) {
            this.uiType = uiType;
        }

    }

    public class Result implements Serializable {

        @SerializedName("number_of_fields")
        @Expose
        private Integer numberOfFields;
        @SerializedName("screen_title")
        @Expose
        private String screenTitle;
        @SerializedName("operator_name")
        @Expose
        private String operatorName;
        @SerializedName("service_id")
        @Expose
        private String serviceId;
        @SerializedName("fields")
        @Expose
        private List<Field> fields = null;


        public Integer getNumberOfFields() {
            return numberOfFields;
        }

        public void setNumberOfFields(Integer numberOfFields) {
            this.numberOfFields = numberOfFields;
        }

        public String getScreenTitle() {
            return screenTitle;
        }

        public void setScreenTitle(String screenTitle) {
            this.screenTitle = screenTitle;
        }

        public String getOperatorName() {
            return operatorName;
        }

        public void setOperatorName(String operatorName) {
            this.operatorName = operatorName;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public List<Field> getFields() {
            return fields;
        }

        public void setFields(List<Field> fields) {
            this.fields = fields;
        }


    }


    public class Type implements Serializable {

        @SerializedName("data_type")
        @Expose
        private String dataType;
        @SerializedName("is_array")
        @Expose
        private String isArray;
        @SerializedName("array_name")
        @Expose
        private String arrayName;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getIsArray() {
            return isArray;
        }

        public void setIsArray(String isArray) {
            this.isArray = isArray;
        }

        public String getArrayName() {
            return arrayName;
        }

        public void setArrayName(String arrayName) {
            this.arrayName = arrayName;
        }

    }

    public class UiType implements Serializable {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("values")
        @Expose
        private List<Value> values = null;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Value> getValues() {
            return values;
        }

        public void setValues(List<Value> values) {
            this.values = values;
        }

        public class Value implements Serializable {

            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("id")
            @Expose
            private String id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

        }
    }
}

