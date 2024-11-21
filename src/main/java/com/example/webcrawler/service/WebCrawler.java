package com.example.webcrawler.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * WebCrawler finds subURLs when given a starting URL.
 * @author Reed Shoolbred
 * Last Updated: 11/6/24
 */
public class WebCrawler {

    //minimum possible length for a URL w/ scheme http:
    private static final int MIN_URL_LENGTH = 9;
    //max # of URLs to traverse
    private static int maxUrls = 50;


    /**
     * Returns URLs found by webcrawling from the given URL. Finds all URLs on one webpage before visiting the next URL and repeating.
     * @param startingUrlString - String representation of the URL to start crawling from
     * @return an ArrayList of all URLs that were found. Null if the starting URL is invalid
     */
    public static ArrayList<URL> crawl(String startingUrlString) {
        //set up ArrayLists to store traversed and pending URLs
        ArrayList<URL> traversedURLs = new ArrayList<>();
        ArrayList<URL> pendingURLs = new ArrayList<>();
        URL startingUrl = convertStringToURL(startingUrlString);
        //return null if provided an invalid URL
        if (startingUrl == null) return null;

        pendingURLs.add(startingUrl);


        while (!pendingURLs.isEmpty() && traversedURLs.size() < maxUrls) {

            //get the next pending URL that has not already been traversed
            URL nextURL = pendingURLs.removeFirst();
            while (traversedURLs.contains(nextURL)){
                nextURL = pendingURLs.removeFirst();
            }

            //create URL object from nextURLString
            try {
                System.out.println("Crawling URL: " + nextURL);
                pendingURLs.addAll(findSubURLs(nextURL));
                traversedURLs.add(nextURL);
            } catch (IOException ioe) {
                System.out.println("IOException, unable to open input stream: " + ioe.getMessage());
            }


        }

        return traversedURLs;
    }

    /**
     * Find and return all URLs listed by the page with the given URL.
     * @param url - any valid URL
     * @return ArrayList of all URLs found in the url parameter
     * @throws IOException if unable to open input stream from URL
     */
    protected static ArrayList<URL> findSubURLs(java.net.URL url) throws IOException {
        //scan file for substrings starting w/ "http:" and ending w/ double quotes (")

        //subURLs will store all subURLs found in url
        ArrayList<URL> subURLs = new ArrayList<>();

        //create scanner to get input from currentURL
        Scanner input = new Scanner(url.openStream());


        while (input.hasNextLine()) {
            findSubURLs(input.nextLine(), subURLs);
        }
        return subURLs;
    }

    /**
     * Find all URLs starting w/ "http:" or "https:" in the given String, and add them to subURLs.
     * @param str - any String
     * @param subURLs - ArrayList to store URLs
     */
    protected static void findSubURLs(String str, ArrayList<URL> subURLs) {

        //get index of next instance of "http:" or "https:"
        int currIndex = findURISchemeIndex(str, 0);
        //loop until all URLs in str have been found
        while (currIndex >= 0) {
            //get the index of the quotation marks following the URL
            int endIndex = str.indexOf("\"", currIndex);
            int urlLength = endIndex - currIndex;

            //URL must be invalid if endIndex <= 0;
            if ((endIndex > 0) && (urlLength > MIN_URL_LENGTH)) {

                //add the URL to subURLs if it is valid
                String possibleUrlString = str.substring(currIndex, endIndex);
                URL possibleUrl = convertStringToURL(possibleUrlString);
                if (possibleUrl != null) subURLs.add(possibleUrl);

                //move currIndex to the start of the next URL if there is one
                currIndex = findURISchemeIndex(str, currIndex + 1);
            }
            //if no index is found, exit loop
            else currIndex = -1;
        }
    }

    /**
     * Search for the next instance of the URI schemes "http:" and "https:" in the given String
     * @param str - any string
     * @param startIndex - index to start searching for the substrings
     * @return - the index of the first scheme to appear in str, or -1 if neither is found
     */
    private static int findURISchemeIndex(String str, int startIndex) {
        //get the indices of both schemes
        int indexHTTP = str.indexOf("http:", startIndex);
        int indexHTTPS = str.indexOf("https:", startIndex);

        //return -1 if neither scheme is found
        if (indexHTTP == -1 && indexHTTPS ==-1) return -1;
        //if only one scheme is found, return that one
        else if (indexHTTP == -1 | indexHTTPS == -1) return Math.max(indexHTTP, indexHTTPS);
        //if both are found, return the one that appears first
        return Math.min(indexHTTP, indexHTTPS);
    }

    /**
     * Convert urlString to a URL object
     * @param urlString - String representing a URL
     * @return URL object created from urlString. Returns null if URL object cannot be created
     * @throws URISyntaxException
     * @throws MalformedURLException
     */
    private static URL convertStringToURL(String urlString) {
        try {
            return new URI(urlString).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            return null;
        }
    }

    public static void setMaxUrls(int max){
        maxUrls = max;
    }
}

