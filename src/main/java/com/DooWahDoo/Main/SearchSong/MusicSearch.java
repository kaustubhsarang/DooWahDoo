package com.DooWahDoo.Main.SearchSong;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.DooWahDoo.Main.Model.MusicLibrary;


@Repository
@Transactional
public class MusicSearch {
	
//	  @PersistenceContext
//	  private EntityManager entityManager;
	  
//	  public List searchAll(String text)
//	  {
//		  FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
//
//		  QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(MusicLibrary.class).get();
////		  org.apache.lucene.search.Query query =queryBuilder.keyword().onFields("artist", "song", "genre").matching(text).createQuery();
//		  org.apache.lucene.search.Query query =queryBuilder.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("title","genre","artist").matching(text).createQuery();
//		  javax.persistence.Query jpaQuery =fullTextEntityManager.createFullTextQuery(query, MusicLibrary.class);
//		  List result = jpaQuery.getResultList();
//		  return result;
//	  }
	  
//	  public List searchSong(String text)
//	  {
//		  FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
//
//		  QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(MusicLibrary.class).get();
////		  org.apache.lucene.search.Query query =queryBuilder.keyword().onFields("artist", "song", "genre").matching(text).createQuery();
//		  org.apache.lucene.search.Query query =queryBuilder.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("title").matching(text).createQuery();
//		  javax.persistence.Query jpaQuery =fullTextEntityManager.createFullTextQuery(query, MusicLibrary.class);
//		  List result = jpaQuery.getResultList();
//		  return result;
//	  }
	  
//	  public List searchArtist(String text)
//	  {
//		  FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
//		  List<String> arr = new ArrayList<String>();
//		  QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(MusicLibrary.class).get();
////		  org.apache.lucene.search.Query query =queryBuilder.keyword().onFields("artist", "song", "genre").matching(text).createQuery();
//		  org.apache.lucene.search.Query query =queryBuilder.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("artist").matching(text).createQuery();
//		  javax.persistence.Query jpaQuery =fullTextEntityManager.createFullTextQuery(query, MusicLibrary.class);
//		  List result = jpaQuery.getResultList();
//		  return result;
//	  }
	  
//	  public List searchGenre(String text)
//	  {
//		  FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
//
//		  QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(MusicLibrary.class).get();
////		  org.apache.lucene.search.Query query =queryBuilder.keyword().onFields("artist", "song", "genre").matching(text).createQuery();
//		  org.apache.lucene.search.Query query =queryBuilder.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("genre").matching(text).createQuery();
//		  javax.persistence.Query jpaQuery =fullTextEntityManager.createFullTextQuery(query, MusicLibrary.class);
//		  List result = jpaQuery.getResultList();
//		  return result;
//	  }

}
