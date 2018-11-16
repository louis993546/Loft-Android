# Moshi adapters

There are a bunch of formatted string that I want retrofit to understand
and parse it for me, without going through moshi, since they are not
objects

- UUID (String -> UUID)
- Timestamp (String -> ZoneDateTime)
- Date (String -> LocalDate)
- etc