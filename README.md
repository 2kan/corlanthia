Corlanthia
--

Corlanthia is an in-development text adventure game written in Java.

Corlanthia has some basic features implemented; so far users can move cardinally, inspect items, pickup items, see their inventory, drop one or many items, look in the room to see what objects are there. There is also a "debug" command that so far adds items to a room and displays all of the items in the room.

Update v0.3.1
--

+ Doors can now be locked
+ Added keys
+ Keys are destroyed when used to unlock a door
+ Added dance command
* Fixed empty line at top of inventory text-area
* Fixed ArrayIndexOutOfBoundsException when trying to go in a direction with no room
* Made 'key' from items list into a skeleton key (spelled 'Skellington Key' in items array) which unlocks every door and is not destroyed upon opening
* Command history is now tracked infinitely (until the vm crashes)
* Other small fixes
* Some polishing of existing features


Next Actions
--

+ More rooms
+ Can read from letters
+ Can inspect doors to get clues as to which key to open it with
+ NPC that can be talked to
* Books and letters will reveal what kind of key will open which door
* Room descriptions will only be shown when walking into the room for the first time


License Info
--

Copyright (c) 2012 Tom Penney

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

See http://www.gnu.org/licenses/gpl-3.0.html for the full GNU General Public License.