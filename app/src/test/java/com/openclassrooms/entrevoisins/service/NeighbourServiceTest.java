package com.openclassrooms.entrevoisins.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;


import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import androidx.annotation.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

//import androidx.test.core.app.ApplicationProvider;


/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;
//    @Mock
//    Context mockContext;
//    @Mock
//    SharedPreferences mockSharedPreferences;
//    @Mock
//    SharedPreferences.Editor mockEditor;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
//        MockitoAnnotations.initMocks(this);

//        Mockito.when(mockContext.getSharedPreferences(anyString(), anyInt())).thenReturn(mockSharedPreferences);
//        Mockito.when(mockContext.getSharedPreferences(anyString(), anyInt()).edit()).thenReturn(mockEditor);
    }


    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void createFavoriteNeighbourWithSuccess() {
        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        service.createFavoriteNeighbour(neighbourToAdd);
        assertTrue(service.getFavoriteNeighbours().contains(neighbourToAdd));
    }


    @Test
    public void deleteFavoriteNeighbourWithSuccess() {
//        Context context = ApplicationProvider.getApplicationContext();
//        Context context = mock(Context.class);

//        when(mockContext.getSharedPreferences("Neighbours", Context.MODE_PRIVATE)).thenReturn(mockSharedPreferences);
//        when(mockContext.getSharedPreferences("Neighbours", Context.MODE_PRIVATE).edit()).thenReturn(mockEditor);

//        List<Neighbour> neighbourToDelete = service.getFavoriteNeighbours(mockContext);
//        assertNull(neighbourToDelete);

//        Neighbour neighbourToDelete = service.getNeighbours().get(3);
//        service.createFavoriteNeighbour(neighbourToDelete, mockContext);
//        assertTrue(service.getFavoriteNeighbours(mockContext).contains(neighbourToDelete));

        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        service.createFavoriteNeighbour(neighbourToAdd);

        Neighbour neighbourToDelete = service.getFavoriteNeighbours().get(0);
        service.deleteFavoriteNeighbour(neighbourToDelete);
        assertFalse(service.getFavoriteNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void getFavoriteNeighboursWithSuccess() {
        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        service.createFavoriteNeighbour(neighbourToAdd);

//        Neighbour neighbourToDelete = service.getFavoriteNeighbours().get(0);
//        service.deleteFavoriteNeighbour(neighbourToDelete);
        assertFalse(service.getFavoriteNeighbours().isEmpty());
    }

}
