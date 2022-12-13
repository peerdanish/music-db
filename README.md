# music-db

# Genre
### *GET* 
### `/api/genre`
### `/api/genre/id`


# Albums 
### *GET*
### `/api/albums/`
### `/api/albums/id`
### `/api/albums/genre/id`

### *POST*
## `/api/albums`
```json 
{"name": "album name"},
{"genreId" : 1}
```

# Artists 
### *GET*
### `/api/artists/id`
### `/api/artists/`

### *POST*
### `/api/artists`
```json 
{"name" : "artist name"}
```
### `/api/artists/albums/albumId`
```json 
{"name" : "artist name"}
```
### `/api/artists/artistId/albums/albumId`
### `/api/artists/max`
