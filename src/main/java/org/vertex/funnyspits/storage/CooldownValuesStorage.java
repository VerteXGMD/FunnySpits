/*
 * MIT License
 *
 * Copyright (c) 2022 Adi Salimgereyev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.vertex.funnyspits.storage;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CooldownValuesStorage {
    private static List<CooldownValuesStorageColumn> columns =
            new ArrayList<>();

    public CooldownValuesStorage() {}

    public boolean playerRegistered(Player player) {
        for (CooldownValuesStorageColumn column: columns) {
            if (column.getPlayer().equals(player)) return true;
        }

        return false;
    }

    public long getPlayerCommandUsageTime(Player player) {
        for (CooldownValuesStorageColumn column: columns) {
            if (column.getPlayer().equals(player)) {
                return column.getLastSpitCommandUsageTime();
            }
        }

        return 0;
    }

    public int getPlayerBonusWaterSpits(Player player) {
        for (CooldownValuesStorageColumn column: columns) {
            if (column.getPlayer().equals(player)) {
                return column.getBonusWaterSpits();
            }
        }

        return 0;
    }

    private void addPlayerCommandUsageTime(Player player, long time) {
        columns.add(new CooldownValuesStorageColumn(player, time, 0));
    }

    private void addPlayerCommandUsageTimeAndAmount(Player player,
                                                           long time, int amount) {
        columns.add(new CooldownValuesStorageColumn(player, time, amount));
    }

    public void setCommandUsageTime(Player player, long time) {
        for (CooldownValuesStorageColumn column: columns) {
            if (column.getPlayer().equals(player)) {
                column.setLastSpitCommandUsageTime(time);
                return;
            }
        }

        addPlayerCommandUsageTime(player, time);
    }

    public void setBonusWaterSpits(Player player, int amount) {
        for (CooldownValuesStorageColumn column: columns) {
            if (column.getPlayer().equals(player)) {
                column.setBonusWaterSpits(amount);
                return;
            }
        }

        addPlayerCommandUsageTimeAndAmount(player,
                System.currentTimeMillis() / 1000, amount);
    }

    public void decreaseBonusWaterSpits(Player player) {
        for (CooldownValuesStorageColumn column: columns) {
            if (column.getPlayer().equals(player)) {
                column.setBonusWaterSpits(column.getBonusWaterSpits() - 1);
            }
        }
    }
}
