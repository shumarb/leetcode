const fs = require('fs');

// Function to update row numbers in the table
function updateTableRows(tableContent) {
  const tableLines = tableContent.split('\n');
  let rowNumber = 1;

  // Keep the header row unchanged, start from the second row
  const updatedTable = tableLines.map((line, index) => {
    // If it's the header row (first line), don't modify it
    if (index === 0 || !line.trim().startsWith('|')) {
      return line;
    }
    // Otherwise, update the row number for each data row
    return line.replace(/^\| \d+ /, `| ${rowNumber++} `); // Update row number
  }).join('\n');

  return updatedTable;
}

// Read the README.md file
fs.readFile('README.md', 'utf8', (err, data) => {
  if (err) {
    console.error('Error reading file:', err);
    return;
  }

  // Regular expression to find all tables in the README.md
  const tableStart = '| #  | Question |';
  const tableEnd = '|----|----------|';  // The separator for the header and data rows

  let startIndex = 0;
  let endIndex = 0;
  let updatedContent = data;

  // Loop through all occurrences of the tables
  while (true) {
    startIndex = updatedContent.indexOf(tableStart, endIndex);
    if (startIndex === -1) break;  // Exit the loop if no more tables are found

    endIndex = updatedContent.indexOf(tableEnd, startIndex) + tableEnd.length;
    const tableContent = updatedContent.slice(startIndex, endIndex);

    // Update row numbers in the current table
    const updatedTable = updateTableRows(tableContent);

    // Replace the old table content with the updated table
    updatedContent = updatedContent.slice(0, startIndex) + updatedTable + updatedContent.slice(endIndex);
  }

  // Write the updated README.md
  fs.writeFile('README.md', updatedContent, 'utf8', err => {
    if (err) {
      console.error('Error writing file:', err);
    } else {
      console.log('README.md updated successfully');
    }
  });
});
