package com.cloudcare.cbis.demo.data.query;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.cloudcare.cbis.demo.data.entity.EOrganizationHasAccount;


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
 * QOrganizationHasAccount is a Querydsl query type for EOrganizationHasAccount
 */
@Label("OrganizationHasAccount查询")
@Generated("com.cloudcare.utils.persistence.codegen.serializer.SimpleMetaDataSerializer")
public class QOrganizationHasAccount extends RelationalPathBase<EOrganizationHasAccount> {

    private static final long serialVersionUID = -1224653431;

    public static final QOrganizationHasAccount organizationHasAccount = new QOrganizationHasAccount("organization_has_account");

    public class PrimaryKeys {

        public final PrimaryKey<EOrganizationHasAccount> primary = createPrimaryKey(id);

    }

    public class ForeignKeys {

        public final ForeignKey<com.cloudcare.cbis.demo.data.entity.EOrganization> organizationHasAccountFk = createForeignKey(organizationId, "id");

        public final ForeignKey<com.cloudcare.cbis.demo.data.entity.EAccount> accountHasOrganizationFk = createForeignKey(accountId, "id");

    }

    public final NumberPath<Integer> accountId = createNumber("accountId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> organizationId = createNumber("organizationId", Integer.class);

    public final PrimaryKeys pk = new PrimaryKeys();

    public final ForeignKeys fk = new ForeignKeys();

    public QOrganizationHasAccount(String variable) {
        super(EOrganizationHasAccount.class, forVariable(variable), "null", "organization_has_account");
        addMetadata();
    }

    public QOrganizationHasAccount(String variable, String schema, String table) {
        super(EOrganizationHasAccount.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QOrganizationHasAccount(Path<? extends EOrganizationHasAccount> path) {
        super(path.getType(), path.getMetadata(), "null", "organization_has_account");
        addMetadata();
    }

    public QOrganizationHasAccount(PathMetadata metadata) {
        super(EOrganizationHasAccount.class, metadata, "null", "organization_has_account");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(accountId, ColumnMetadata.named("account_id").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(organizationId, ColumnMetadata.named("organization_id").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

