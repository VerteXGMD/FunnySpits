<p align="center"><img src="./main_animation.gif" /><br>Easy-to-use fun plugin that just adds ability to... spit :3</p>

# How to spit?
Just use `/funnyspits spit` command! You can also use `/spit`,
which is more faster to type :3.

# Configuration
The configuration file is only one and called `config.yml`.

> To reload config file values use `/funnyspits reload` command.

## `spit_command_permission`:
If you want only players who have the specific permission to be able to "spit", change the parameter's value to that specific permission. 
If you want everybody to be able to "spit", then set its value to `''`.

## `spit_command_not_enough_permissions_message`: 
Message that shows up if player doesn't have specified earlier permission, but tries to run the spit command.

## `spit_with_sound`:
Set to `true` if you want sound of llama spit to be played near the location of where the player has spat at else set to `false`.

## `spit_intensity`:
Intensity value of "spit" (number), value is required to be in the interval of numbers from 1 to 10. This animation will accuratly show you the difference:

<p align="center"><img src="./intensity_animation.gif" /> </p>

## `spit_damage`:
Damage that will be inflicted on the player/mob if it was spat.
Must be set to 0 if you want next option to come in place
(if the option has a value of true)!

## `spit_kill`:
Kills player/mob if it was spat if the value is true.

## `spit_command_cooldown`:
Spit command cooldown (if value is zero, cooldown is cancelled).

## `spit_command_cooldown_not_over_message`:
Message shown when cooldown is not over.

## `reload_command_permission`:
Permission for that player to be able to run plugin config reload command.

## `reload_command_not_enough_permissions_message`:
Message that shows up if player doesn't have specified earlier permission, but tries to run the reload command.

## `reload_command_success_message`:
Message that shows up if plugin was reloaded successfully.
