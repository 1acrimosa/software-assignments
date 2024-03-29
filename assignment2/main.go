package main
import ("fmt")


// LibraryItem interface for items in the catalog
type LibraryItem interface {
	GetTitle() string
}

// Book struct for books
type Book struct {
	Title  string
	Author string
}

// GetTitle returns the title of the book
func (b Book) GetTitle() string {
	return b.Title
}

// Magazine struct for magazines
type Magazine struct {
	Title  string
	Editor string
}

// GetTitle returns the title of the magazine
func (m Magazine) GetTitle() string {
	return m.Title
}

// CD struct for CDs
type CD struct {
	Title  string
	Artist string
}

// GetTitle returns the title of the CD
func (c CD) GetTitle() string {
	return c.Title
}

// UserPermission interface for managing user permissions
type UserPermission interface {
	HasPermission() bool
}

// Librarian struct representing a librarian
type Librarian struct{}

// HasPermission returns true for a librarian
func (l Librarian) HasPermission() bool {
	return true
}

// Patron struct representing a patron
type Patron struct{}

// HasPermission returns false for a patron
func (p Patron) HasPermission() bool {
	return false
}

// LibraryCatalogManager interface for managing the library catalog
type LibraryCatalogManager interface {
	AddItem(item LibraryItem)
	RemoveItem(item LibraryItem)
	ListItems()
}

// SimpleLibraryCatalogManager struct implementing LibraryCatalogManager
type SimpleLibraryCatalogManager struct {
	Items []LibraryItem
}

// AddItem adds an item to the catalog
func (sm SimpleLibraryCatalogManager) AddItem(item LibraryItem) {
	sm.Items = append(sm.Items, item)
}

// RemoveItem removes an item from the catalog
func (sm *SimpleLibraryCatalogManager) RemoveItem(item LibraryItem) {
	for i, it := range sm.Items {
		if it == item {
			sm.Items = append(sm.Items[:i], sm.Items[i+1:]...)
			break
		}
	}
}

// ListItems lists all items in the catalog
func (sm SimpleLibraryCatalogManager) ListItems() {
	for _, item := range sm.Items {
		fmt.Println(item.GetTitle())
	}
}

// LibraryCLI struct for the command-line interface
type LibraryCLI struct {
	CatalogManager LibraryCatalogManager
}

// Run starts the command-line interface
func (cli LibraryCLI) Run() {
	fmt.Println("Welcome, librarian!")
	for {
		var choice string
		fmt.Println("1. Add item\n2. Remove item\n3. List items\n4. Exit")
		fmt.Print("Enter your choice: ")
		fmt.Scanln(&choice)

		switch choice {
		case "1":
			var title, author string
			fmt.Print("Enter title: ")
			fmt.Scanln(&title)
			fmt.Print("Enter author: ")
			fmt.Scanln(&author)
			item := Book{Title: title, Author: author}
			cli.CatalogManager.AddItem(item)
		case "2":
			var title string
			fmt.Print("Enter title of item to remove: ")
			fmt.Scanln(&title)
			// Find and remove item from catalog
		case "3":
			cli.CatalogManager.ListItems()
		case "4":
			fmt.Println("Goodbye!")
			return
		default:
			fmt.Println("Invalid choice. Please try again.")
		}
	}
}

func main() {
	manager := SimpleLibraryCatalogManager{}
	cli := LibraryCLI{CatalogManager: &manager}
	cli.Run()
}
