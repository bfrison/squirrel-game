package com.frison.blaise.assignment2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.frison.blaise.assignment2.fragments.GameControlsFragment;
import com.frison.blaise.assignment2.fragments.InventoryFragment;
import com.frison.blaise.assignment2.fragments.MapFragment;

/**
 * Created by Blaise on 28/oct./2017.
 */

public class Game extends AppCompatActivity {

    private Forest forest;
    private Inventory inventory;
    private static final int INITIAL_X = 3;
    private static final int INITIAL_Y = 10;
    private MapFragment mapFragment;
    private GameMode gameMode;

    private enum GameMode {MAP, INVENTORY}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        this.gameMode = GameMode.MAP;

        if (savedInstanceState != null && savedInstanceState.get("forest") != null) {
            this.forest = (Forest) savedInstanceState.get("forest");
            this.inventory = (Inventory)savedInstanceState.get("inventory");
        } else {
            this.forest = new Forest(INITIAL_X, INITIAL_Y);
            this.inventory = new Inventory();
        }

        mapFragment = new MapFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.play_area, mapFragment)
                .add(R.id.controls_area, new GameControlsFragment())
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.game_area_in, R.anim.main_menu_out);
    }

    public Forest getForest() {
        return this.forest;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void moveSquirrel(View view) {
        String desc = view.getContentDescription().toString();
        String up = getResources().getString(R.string.up_arrow);
        String left = getResources().getString(R.string.left_arrow);
        String right = getResources().getString(R.string.right_arrow);
        String down = getResources().getString(R.string.down_arrow);

        if (desc.equals(up)) {
            this.forest.move(Forest.Direction.UP);
        } else if (desc.equals(left)) {
            this.forest.move(Forest.Direction.LEFT);
        } else if (desc.equals(right)) {
            this.forest.move(Forest.Direction.RIGHT);
        } else if (desc.equals(down)) {
            this.forest.move(Forest.Direction.DOWN);
        }
        updateMapFragment();
    }

    public void pickupAcorn(View view) {
        if (this.forest.squirrelOnAcorn() && this.inventory.canPickup()) {
            this.forest.removeAcorn();
            this.inventory.pickup();
        }
    }

    public void dropAcorn(View view) {
        int index = Integer.parseInt(view.getContentDescription().toString());
        if (!this.forest.squirrelOnAcorn() && this.inventory.get(index)) {
            this.forest.addAcorn();
            this.inventory.drop(index);
        }
        updateInventoryFragment();
    }

    public void goToInventoryMap(View view) {
        if (gameMode == GameMode.MAP) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.play_area, new InventoryFragment())
                    .commit();
            gameMode = GameMode.INVENTORY;
            String buttonMap = getResources().getString(R.string.map_button);
            ((Button) findViewById(R.id.button_inventory_map)).setText(buttonMap);
        } else if (gameMode == GameMode.INVENTORY) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.play_area, new MapFragment())
                    .commit();
            gameMode = GameMode.MAP;
            String buttonInventory = getResources().getString(R.string.inventory_button);
            ((Button) findViewById(R.id.button_inventory_map)).setText(buttonInventory);
        }
    }

    public void updateMapFragment() {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.play_area, new MapFragment())
                    .commit();
    }

    public void updateInventoryFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.play_area, new InventoryFragment())
                .commit();
    }

}
