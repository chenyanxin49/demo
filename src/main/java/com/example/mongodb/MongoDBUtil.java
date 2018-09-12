package com.example.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @program: realtour-r8-qj-b2b
 * @description: MongoDb工具类
 * @author: chenyanxin
 * @create: 2018-08-28 14:28
 **/
public class MongoDBUtil {

    private static final Logger LogTools = LoggerFactory.getLogger(MongoDBUtil.class);
    private static MongoDBUtil mongoDBUtil;

    private static final String PLEASE_SEND_IP = "没有传入ip或者端口号";
    private static final String PLEASE_INSTANCE_MONGOCLIENT = "请实例化MongoClient";
    private static final String PLEASE_SEND_MONGO_REPOSITORY = "请指定要删除的mongo库";
    private static final String DELETE_MONGO_REPOSITORY_EXCEPTION = "删除mongo库异常";
    private static final String DELETE_MONGO_REPOSITORY_SUCCESS = "批量删除mongo库成功";
    private static final String NOT_DELETE_MONGO_REPOSITORY = "未删除mongo库";
    private static final String DELETE_MONGO_REPOSITORY = "成功删除mongo库：";
    private static final String CREATE_MONGO_COLLECTION_NOTE = "请指定要创建的库";
    private static final String NO_THIS_MONGO_DATABASE = "未找到指定mongo库";
    private static final String CREATE_MONGO_COLLECTION_SUCCESS = "创建mongo库成功";
    private static final String CREATE_MONGO_COLLECTION_EXCEPTION = "创建mongo库错误";
    private static final String NOT_CREATE_MONGO_COLLECTION = "未创建mongo库collection";
    private static final String CREATE_MONGO_COLLECTION_SUCH = "创建mongo库collection：";
    private static final String NO_FOUND_MONGO_COLLECTION = "未找到mongo库collection";
    private static final String INSERT_DOCUMEN_EXCEPTION = "插入失败";
    private static final String INSERT_DOCUMEN_SUCCESSS = "插入成功";

    private MongoDBUtil() {

    }

    private static class SingleHolder {
        private static MongoDBUtil mongoDBUtil = new MongoDBUtil();
    }

    public static MongoDBUtil instance() {

        return SingleHolder.mongoDBUtil;
    }

    public static MongoDBUtil getMongoDBUtilInstance() {
        if (mongoDBUtil == null) {
            return new MongoDBUtil();
        }
        return mongoDBUtil;
    }

    /**
     * 获取mongoDB连接
     *
     * @param host ip
     * @param port 端口号
     * @return 实例
     */
    public MongoClient getMongoConnect(String host, Integer port) {

        if (StringUtils.isEmpty(host) || null == port) {
            LogTools.info(PLEASE_SEND_IP);
            return null;
        }

        return new MongoClient(host, port);
    }


    /**
     * 批量删除mongo库
     *
     * @param mongoClient 客户端实例
     * @param dbNames     库名
     * @return 执行结果信息
     */
    public String bulkDropDataBase(MongoClient mongoClient, String... dbNames) {

        if (null == mongoClient) {
            return PLEASE_INSTANCE_MONGOCLIENT;
        }

        if (null == dbNames || dbNames.length == 0) {
            return PLEASE_SEND_MONGO_REPOSITORY;
        }
        try {
            Arrays.asList(dbNames).forEach(mongoClient::dropDatabase);
            LogTools.info(DELETE_MONGO_REPOSITORY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            LogTools.error(DELETE_MONGO_REPOSITORY_EXCEPTION, e);
        }
        return DELETE_MONGO_REPOSITORY + String.join(",", dbNames);
    }


    /**
     * 创建指定database的collection
     *
     * @param mongoClient 客户端实例
     * @param dbName      库名
     * @param collections 表名
     * @return 执行结果信息
     */
    public String createCollections(MongoClient mongoClient, String dbName, String... collections) {

        if (null == mongoClient) {
            return PLEASE_INSTANCE_MONGOCLIENT;
        }

        if (null == collections || collections.length == 0) {
            return CREATE_MONGO_COLLECTION_NOTE;
        }

        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
        if (null == mongoDatabase) {
            return NO_THIS_MONGO_DATABASE;
        }

        try {
            Arrays.asList(collections).forEach(mongoDatabase::createCollection);
            LogTools.info(CREATE_MONGO_COLLECTION_SUCCESS);
            return CREATE_MONGO_COLLECTION_SUCH + String.join(",", collections);
        } catch (Exception e) {
            e.printStackTrace();
            LogTools.error(CREATE_MONGO_COLLECTION_EXCEPTION, e);
        }

        return null;
    }

    /**
     * 获取MongoCollection
     *
     * @param mongoClient 客户端实例
     * @param dbName      库名
     * @param collection  表名
     * @return 结果集
     */
    public MongoCollection<Document> getMongoCollection(MongoClient mongoClient, String dbName, String collection) {

        if (null == mongoClient) {
            return null;
        }

        if (StringUtils.isBlank(dbName)) {
            return null;
        }

        if (StringUtils.isBlank(collection)) {
            return null;
        }

        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);

        MongoCollection<Document> collectionDocuments = mongoDatabase.getCollection(collection);

        if (null == collectionDocuments) {
            return null;
        }

        return collectionDocuments;
    }

    /**
     * 获取到MongoClient
     *
     * @param ip       ip
     * @param port     端口
     * @param userName 用户名
     * @param dbName   库名
     * @param psw      密码
     * @return MongoClient
     */
    public static MongoClient getMongoClientByCredential(String ip, int port, String userName, String dbName, String psw) {
        ServerAddress serverAddress = new ServerAddress(ip, port);
        List<ServerAddress> addrs = new ArrayList<>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential(userName, dbName, psw.toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);

        //通过连接认证获取MongoDB连接
        return null;
    }


    /**
     * 插入文档数据
     *
     * @param mongoCollection
     * @param params
     */
    public void insertDoucument(final MongoCollection<Document> mongoCollection, final Map<String, Object> params) {
        if (null == mongoCollection) {
            LogTools.info(NO_FOUND_MONGO_COLLECTION);
            return;
        }

        try {
            Document document = new Document();
            params.keySet().forEach(field -> document.append(field, params.get(field)));

            List<Document> documents = new ArrayList<>();
            documents.add(document);
            mongoCollection.insertMany(documents);
            LogTools.info(INSERT_DOCUMEN_SUCCESSS);
        } catch (Exception e) {
            e.printStackTrace();
            LogTools.error(INSERT_DOCUMEN_EXCEPTION, e);
        }
    }

    /**
     * 更新文档
     *
     * @param mongoCollection
     * @param conditionParams
     * @param updateParams
     */
    public void updateDocument(final MongoCollection<Document> mongoCollection, final Map<String, Object> conditionParams,
                               final Map<String, Object> updateParams, final boolean multiUpdate
    ) {

        if (null == mongoCollection) {
            return;
        }

        if (null == conditionParams) {
            return;
        }

        if (null == updateParams) {
            return;
        }


        Document conditonDocument = new Document();
        conditionParams.keySet().stream().filter(Objects::nonNull).forEach(o -> {
            conditonDocument.append(o, conditionParams.get(o));
        });


        Document updateDocument = new Document();
        updateParams.keySet().stream().filter(Objects::nonNull).forEach(o -> {
            updateDocument.append(o, updateParams.get(o));
        });
        UpdateResult updateResult;
        if (multiUpdate) {
            //是否批量更新
            updateResult = mongoCollection.updateMany(conditonDocument, new Document("$set", updateDocument));
        } else {
            updateResult = mongoCollection.updateOne(conditonDocument, new Document("$set", updateDocument));
        }
        System.out.println("修改了：" + updateResult.getModifiedCount() + " 条数据 ");

    }

    /**
     * 条件 删除文档 是否多条删除
     *
     * @param mongoCollection
     * @param multiple
     * @param conditionParams
     * @return
     */
    public long deleteDocument(final MongoCollection<Document> mongoCollection, final boolean multiple,
                               final Map<String, Object> conditionParams) {

        if (null == mongoCollection) {
            return 0;
        }

        if (null == conditionParams) {
            return 0;
        }

        Document document = new Document();

        conditionParams.keySet().stream().filter(Objects::nonNull).forEach(o -> {
            document.append(o, conditionParams.get(o));
        });

        if (multiple) {
            return mongoCollection.deleteMany(document).getDeletedCount();
        }

        //删除文档第一条
        return mongoCollection.deleteOne(document).getDeletedCount();
    }

    /**
     * 查询文档 带条件、范围查找、排序、分页
     *
     * @param mongoCollection
     * @param conditionParams
     * @param limit
     * @param skip
     * @param sortParams
     */
    public FindIterable<Document> queryDocument(final MongoCollection<Document> mongoCollection, final Map<String, Object> conditionParams,
                                                final String op, final String compareField, final Map<String, Integer> gtLtOrOtherParams,
                                                final Map<String, Object> sortParams, final Integer skip, final Integer limit
    ) {

        if (null == mongoCollection) {
            return null;
        }

        FindIterable<Document> findIterable = mongoCollection.find();
        Document conditionDocument = new Document();
        Document compareDocument = new Document();

        if (null != conditionParams && null != findIterable) {

            conditionParams.forEach((k, v) -> {
                if (StringUtils.isNotBlank(k)) {
                    conditionDocument.append(k, v);
                }
            });

            findIterable = findIterable.filter(conditionDocument);

            for (Document aFindIterable : findIterable) {
                System.out.println("条件过滤  -->" + aFindIterable);
            }
        }

        if (null != findIterable && null != gtLtOrOtherParams) {

            Document gtOrLtDoc = new Document();
            gtLtOrOtherParams.forEach((k, v) -> {
                if (StringUtils.isNotBlank(k)) {
                    gtOrLtDoc.append(k, v);
                }
            });

            compareDocument = new Document(compareField, gtOrLtDoc);
            findIterable = findIterable.filter(new Document(compareField, compareDocument));
        }

        if (StringUtils.isNotBlank(op)) {
            if ("and".equals(op)) {
                findIterable = mongoCollection.find(Filters.and(conditionDocument, compareDocument));
            } else if ("or".equals(op)) {
                findIterable = mongoCollection.find(Filters.or(conditionDocument, compareDocument));
            } else if ("not".equals(op)) {
                //排除范围
                findIterable = mongoCollection.find(Filters.and(conditionDocument, Filters.not(compareDocument)));
            }
        } else {//默认是AND查询
            findIterable = mongoCollection.find(Filters.and(conditionDocument, compareDocument));
        }
        for (Document aFindIterable : findIterable) {
            System.out.println(op + "过滤  -->" + aFindIterable);
        }

        if (null != sortParams) {
            Document sortDocument = new Document();
            sortParams.forEach((k, v) -> {
                if (StringUtils.isNotBlank(k)) {
                    sortDocument.append(k, v);
                }
            });

            findIterable = findIterable.sort(sortDocument);

            for (Document aFindIterable : findIterable) {
                System.out.println("排序  -->" + aFindIterable);
            }
        }


        if (null != limit) {
            findIterable = findIterable.limit(limit);
        }
        if (null != findIterable && null != skip) {
            findIterable = findIterable.skip(skip);
        }

        return findIterable;
    }


    /**
     * in查询
     *
     * @param mongoCollection
     * @return
     */
    public FindIterable<Document> queryDocumentIn(final MongoCollection<Document> mongoCollection, String field, List<String> list
    ) {

        if (null == mongoCollection) {
            return null;
        }
        return mongoCollection.find(new Document(field, new Document("$in", list)));
    }


    /**
     * 全文查询
     *
     * @param mongoCollection
     * @return
     */
    public FindIterable<Document> queryDocument(final MongoCollection<Document> mongoCollection
    ) {
        if (null == mongoCollection) {
            return null;
        }
        return mongoCollection.find();
    }


    /**
     * 查询文档 简单条件查询
     *
     * @param mongoCollection
     * @param conditionParams
     * @return
     */
    public FindIterable<Document> queryDocument(final MongoCollection<Document> mongoCollection, final Map<String, Object> conditionParams
    ) {

        if (null == mongoCollection) {
            return null;
        }

        FindIterable<Document> findIterable = mongoCollection.find();

        if (null == conditionParams || null == findIterable) {
            return findIterable;
        }

        Document document = new Document();
        conditionParams.forEach((k, v) -> {
            if (StringUtils.isNotBlank(k)) {
                document.append(k, v);
            }
        });
        findIterable = findIterable.filter(document);

        return findIterable;

    }


    /**
     * 用于输出部分的列信息
     *
     * @param documents 部分的列信息
     */
    public static void printDocuments(FindIterable<Document> documents, String[] fields) {
        if (fields != null && fields.length > 0) {
            int num = 0;
            for (Document d : documents) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String field : fields) {
                    /*if(fields[i].equals("catm")){

                    }*/
                    stringBuilder.append(field)
                            .append(": ")
                            .append(d.getString(field))
                            .append(" ");
                }
                System.out.println("第" + (++num) + "条数据： " + stringBuilder);

            }
        } else {
            for (Document d : documents) {
                System.out.println(d.toString());
            }
        }
    }

    /**
     * 用于输出所有的列信息
     *
     * @param documents 所有的列信息
     */
    public void printDocuments(FindIterable<Document> documents) {
        int num = 0;
        for (Document d : documents) {
            System.out.println("第" + (++num) + "条数据： " + d.toString());
        }
    }

}
