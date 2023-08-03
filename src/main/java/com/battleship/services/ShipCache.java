package com.battleship.services;

import com.battleship.model.WarShip;

import java.util.*;

public class ShipCache {
    private static Map<WarShip.ShipType, List<WarShip>> CACHED_CREATED_SHIPS_MAP;

    public static void cache(WarShip ship) {
        WarShip.ShipType type = ship.getShipType();
        if (!CACHED_CREATED_SHIPS_MAP.containsKey(type)) {
            CACHED_CREATED_SHIPS_MAP.put(type, new ArrayList<>(List.of(ship)));
            return;
        }

        var ships = CACHED_CREATED_SHIPS_MAP.get(type);
        ships.add(ship);

        CACHED_CREATED_SHIPS_MAP.put(type, ships);
    }

    public static Map<WarShip.ShipType, List<WarShip>> getCache() {
        if (CACHED_CREATED_SHIPS_MAP == null) {
            CACHED_CREATED_SHIPS_MAP = new HashMap<>();
        }
        return CACHED_CREATED_SHIPS_MAP;
    }

    public static List<WarShip> getShipList(WarShip.ShipType shipType) {
        if (CACHED_CREATED_SHIPS_MAP == null) {
            getCache();
        }

        return CACHED_CREATED_SHIPS_MAP.getOrDefault(shipType, Collections.emptyList());
    }

    public static int getShipsListSize(WarShip.ShipType shipType) {
        return getShipList(shipType).size();
    }
}
