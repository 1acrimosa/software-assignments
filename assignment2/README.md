# SRP: 
Each type has a single responsibility. For instance, Book, Magazine, and CD handle information related to their respective items. LibraryCLI manages user interaction, and SimpleLibraryCatalogManager handles the library catalog.

---

# OCP: 
The system allows for extension without modification by defining interfaces and structs that can be extended. New types of items can be added by implementing the LibraryItem interface.

---

# LSP: 
Subtypes such as Book, Magazine, and CD can be substituted for the LibraryItem interface without affecting program behavior. This provides flexibility in handling different types of items in the catalog.

---

# ISP: 
Interfaces are designed to meet the specific needs of clients. For instance, LibraryCatalogManager provides methods for managing the catalog, while UserPermission defines permissions relevant to users.

---

# DIP: 
High-level modules like LibraryCLI and SimpleLibraryCatalogManager depend on abstractions (LibraryItem, UserPermission) rather than concrete implementations, promoting loose coupling and easier maintenance.
