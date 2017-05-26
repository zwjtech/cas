package com.cloudcare.cbis.demo.data;

import com.cloudcare.cbis.demo.face.dict.OrganizationType;
import com.cloudcare.common.lang.Configs;
import com.cloudcare.utils.persistence.codegen.SimpleMetaDataExporter;
import com.cloudcare.utils.persistence.codegen.serializer.*;
import com.mysema.codegen.model.ClassType;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.types.DateTimeType;
import com.querydsl.sql.types.LocalDateType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ASUS on 2017/5/11.
 */
public class DomainCodeGenTest {
    ApplicationContext ctx;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
    }

    @Test
    public void generateCode() throws SQLException {
        Connection connection = null;
        try {
            DataSource ds = (DataSource) ctx.getBean("dataSource");
            SimpleMetaDataExporter exporter = new SimpleMetaDataExporter();
            exporter.setBeanPrefix("E");
            exporter.setPackageName("com.cloudcare.cbis.demo.data");
            exporter.setValidationAnnotations(true);

            SimpleBeanSerializer beanSerializer = new SimpleBeanSerializer();
            beanSerializer.setAddToString(true);
            beanSerializer.setPrintSupertype(true);
            exporter.setBeanSerializer(beanSerializer);

            SimpleModelSerializer voSerializer = new SimpleModelSerializer();
            voSerializer.setAddFullConstructor(true);
            voSerializer.setAddToString(true);
            voSerializer.setPrintSupertype(true);
            exporter.setModelSerializer(voSerializer);

            exporter.setMetadataSerializerClass(SimpleMetaDataSerializer.class);

            SimpleDaoIfcSerializer daoIfcSerializer = new SimpleDaoIfcSerializer();
            exporter.setDaoIfcSerializer(daoIfcSerializer);
            SimpleDaoImplSerializer daoImplSerializer = new SimpleDaoImplSerializer();
            exporter.setDaoImplSerializer(daoImplSerializer);

            SimpleActionFactorySerializer actionFactorySerializer = new SimpleActionFactorySerializer();
            exporter.setActionFactorySerializer(actionFactorySerializer);

            exporter.registerVoDataType("com.cloudcare.cbis.demo.data.model.Organization", "orgType", new ClassType(OrganizationType.class));

            exporter.setTargetFolder(new File("src/main/java"));
            connection = ds.getConnection();
            exporter.setInnerClassesForKeys(true);
            Configuration configuration = new Configuration(SQLTemplates.DEFAULT);
            configuration.registerNumeric(10, 2, BigDecimal.class);
            configuration.register(new LocalDateType());
            configuration.register(new DateTimeType());
            exporter.setConfiguration(configuration);
            exporter.export(connection.getMetaData(), connection.createStatement());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
