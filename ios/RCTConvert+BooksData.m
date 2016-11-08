//
//  RCTConvert+BooksData.m
//  genas
//
//  Created by Henadzi Stoma on 11/4/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "RCTConvert+BooksData.h"

@implementation RCTConvert (BooksData)
+ (BooksData *) BooksData:(id)json {
  json = [self NSArray:json];
  BooksData* _itemsArray = [[BooksData alloc] init];
  NSDictionary* dict;
  for (int i=0; i<[json count]; i++) {
    dict = [self NSDictionary:[json objectAtIndex:i]];
    NSLog(@"-------!!!!!!!-------%@", dict);
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:[dict objectForKey:@"title"] withUrl:[dict objectForKey:@"url"]]];
  }
  

  return _itemsArray;
}
@end
