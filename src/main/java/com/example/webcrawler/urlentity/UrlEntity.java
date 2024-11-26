package com.example.webcrawler.urlentity;

import jakarta.persistence.*;

/**
 * UrlEntity provides database mapping for a Java URL object.
 */
@Entity
@Table(name="url")
public class UrlEntity {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="scheme")
    private String scheme;

    @Column(name="domain")
    private String domain;

    @Column(name="port")
    private int port;

    @Column(name="path")
    private String path;

    @Column(name="query_parameters")
    private String queryParameters;

    @Column(name="fragment")
    private String fragment;

    public UrlEntity() {

    }

    public UrlEntity(java.net.URL url){
        this.scheme = url.getProtocol();
        this.domain = url.getHost();
        this.port = url.getPort();
        this.path = url.getPath();
        this.queryParameters = url.getQuery();
        this.fragment = url.getRef();
    }

    public int getId() {
        return id;
    }

    public String getScheme() {
        return scheme;
    }

    public String getDomain() {
        return domain;
    }

    public int getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public String getQueryParameters() {
        return queryParameters;
    }

    public String getFragment() {
        return fragment;
    }


    @Override
    public String toString() {

        StringBuilder url = new StringBuilder(scheme + ":" + domain);
        if (port > -1) url.append(port);
        url.append(path);
        if (queryParameters != null) url.append("?" + queryParameters);
        if (fragment != null) url.append("#" + fragment);

        return url.toString();
    }

}
