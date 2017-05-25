package com.cloudcare.cbis.demo.data.query;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.cloudcare.cbis.demo.data.entity.EAccount;


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
 * QAccount is a Querydsl query type for EAccount
 */
@Label("Account查询")
@Generated("com.cloudcare.utils.persistence.codegen.serializer.SimpleMetaDataSerializer")
public class QAccount extends RelationalPathBase<EAccount> {

    private static final long serialVersionUID = -398931254;

    public static final QAccount account = new QAccount("account");

    public class PrimaryKeys {

        public final PrimaryKey<EAccount> primary = createPrimaryKey(id);

    }

    public class ForeignKeys {

        public final ForeignKey<com.cloudcare.cbis.demo.data.entity.EOrganizationHasAccount> _accountHasOrganizationFk = createInvForeignKey(id, "account_id");

    }

    public final DateTimePath<org.joda.time.DateTime> createTime = createDateTime("createTime", org.joda.time.DateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final DateTimePath<org.joda.time.DateTime> updateTime = createDateTime("updateTime", org.joda.time.DateTime.class);

    public final PrimaryKeys pk = new PrimaryKeys();

    public final ForeignKeys fk = new ForeignKeys();

    public QAccount(String variable) {
        super(EAccount.class, forVariable(variable), "null", "account");
        addMetadata();
    }

    public QAccount(String variable, String schema, String table) {
        super(EAccount.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QAccount(Path<? extends EAccount> path) {
        super(path.getType(), path.getMetadata(), "null", "account");
        addMetadata();
    }

    public QAccount(PathMetadata metadata) {
        super(EAccount.class, metadata, "null", "account");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(createTime, ColumnMetadata.named("create_time").withIndex(3).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(45));
        addMetadata(password, ColumnMetadata.named("password").withIndex(5).ofType(Types.VARCHAR).withSize(64));
        addMetadata(updateTime, ColumnMetadata.named("update_time").withIndex(4).ofType(Types.TIMESTAMP).withSize(19));
    }

}

