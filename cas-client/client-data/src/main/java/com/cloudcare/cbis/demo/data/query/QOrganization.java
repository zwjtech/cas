package com.cloudcare.cbis.demo.data.query;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.cloudcare.cbis.demo.data.entity.EOrganization;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;

import com.querydsl.sql.*;

import com.cloudcare.common.lang.annotation.Uniques;
import com.cloudcare.common.lang.annotation.Label;


/**
 * QOrganization is a Querydsl query type for EOrganization
 */
@Label("Organization查询")
@Generated("com.cloudcare.utils.persistence.codegen.serializer.SimpleMetaDataSerializer")
public class QOrganization extends RelationalPathBase<EOrganization> {

    private static final long serialVersionUID = -1861187914;

    public static final QOrganization organization = new QOrganization("organization");

    public class PrimaryKeys {

        public final PrimaryKey<EOrganization> primary = createPrimaryKey(id);

    }

    public class ForeignKeys {

        public final ForeignKey<com.cloudcare.cbis.demo.data.entity.EOrganizationHasAccount> _organizationHasAccountFk = createInvForeignKey(id, "organization_id");

    }

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath orgType = createString("orgType");

    public final PrimaryKeys pk = new PrimaryKeys();

    public final ForeignKeys fk = new ForeignKeys();

    public QOrganization(String variable) {
        super(EOrganization.class, forVariable(variable), "null", "organization");
        addMetadata();
    }

    public QOrganization(String variable, String schema, String table) {
        super(EOrganization.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QOrganization(Path<? extends EOrganization> path) {
        super(path.getType(), path.getMetadata(), "null", "organization");
        addMetadata();
    }

    public QOrganization(PathMetadata metadata) {
        super(EOrganization.class, metadata, "null", "organization");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(128).notNull());
        addMetadata(orgType, ColumnMetadata.named("org_type").withIndex(3).ofType(Types.VARCHAR).withSize(32));
    }

}

