package me.module.multiserver.library.redis.jedis.search.schemafields;

import java.util.LinkedHashMap;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.search.FieldName;
import me.module.multiserver.library.redis.jedis.search.SearchProtocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/schemafields/VectorField.class */
public class VectorField extends SchemaField {
    private final VectorAlgorithm algorithm;
    private final Map<String, Object> attributes;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/schemafields/VectorField$Builder.class */
    public static class Builder {
        private FieldName fieldName;
        private VectorAlgorithm algorithm;
        private Map<String, Object> attributes;

        private Builder() {
        }

        public VectorField build() {
            if (this.fieldName == null || this.algorithm == null || this.attributes == null || this.attributes.isEmpty()) {
                throw new IllegalArgumentException("All required VectorField parameters are not set.");
            }
            return new VectorField(this.fieldName, this.algorithm, this.attributes);
        }

        public Builder fieldName(String str) {
            this.fieldName = FieldName.of(str);
            return this;
        }

        public Builder fieldName(FieldName fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public Builder as(String str) {
            this.fieldName.as(str);
            return this;
        }

        public Builder algorithm(VectorAlgorithm vectorAlgorithm) {
            this.algorithm = vectorAlgorithm;
            return this;
        }

        public Builder attributes(Map<String, Object> map) {
            this.attributes = map;
            return this;
        }

        public Builder addAttribute(String str, Object obj) {
            if (this.attributes == null) {
                this.attributes = new LinkedHashMap();
            }
            this.attributes.put(str, obj);
            return this;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/schemafields/VectorField$VectorAlgorithm.class */
    public enum VectorAlgorithm {
        FLAT,
        HNSW
    }

    public VectorField(String str, VectorAlgorithm vectorAlgorithm, Map<String, Object> map) {
        super(str);
        this.algorithm = vectorAlgorithm;
        this.attributes = map;
    }

    public VectorField(FieldName fieldName, VectorAlgorithm vectorAlgorithm, Map<String, Object> map) {
        super(fieldName);
        this.algorithm = vectorAlgorithm;
        this.attributes = map;
    }

    @Override // me.module.multiserver.library.redis.jedis.search.schemafields.SchemaField
    public VectorField as(String str) {
        super.as(str);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        commandArguments.addParams(this.fieldName);
        commandArguments.add(SearchProtocol.SearchKeyword.VECTOR);
        commandArguments.add(this.algorithm);
        commandArguments.add(Integer.valueOf(this.attributes.size() * 2));
        this.attributes.forEach((str, obj) -> {
            commandArguments.add(str).add(obj);
        });
    }

    public static Builder builder() {
        return new Builder();
    }
}
